package com.kamiltest.demo.manager;

import com.kamiltest.demo.doa.Repo.UserRepo;
import com.kamiltest.demo.doa.model.MyUserDetails;
import com.kamiltest.demo.doa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleService roleService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username != null)
        {
            //should be userdetails?
            Optional<User> userFromDb = this.userRepo.findUserByUsername(username);
            if(userFromDb.isPresent())
            {
                return new MyUserDetails(userFromDb.get());
            }
            else if(!userFromDb.isPresent())
            {
                throw new UsernameNotFoundException("User not found in database");
            }
        }
        return null;
    }

    public boolean addUser(User user){
        try{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setEnabled(true);
            this.userRepo.save(user);
            return true;
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
            return false;
        }
    }

    public Iterable<User> findAllUsers(){return this.userRepo.findAll();}
    public Optional<User> findUserById(Long id){return this.userRepo.findById(id);}
    public void deleteUser(Long id){this.userRepo.deleteById(id);}

//    quick assign user to database but without role
//    @EventListener(ApplicationReadyEvent.class)
//    public void addStartUsersToDb()
//    {
//        User admin = new User();
//        admin.setEnabled(true);
//        admin.setUsername("work");
//        admin.setPassword(passwordEncoder.encode("work"));
//        this.userRepo.save(admin);
//    }
}
