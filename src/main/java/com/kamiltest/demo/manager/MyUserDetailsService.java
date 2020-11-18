package com.kamiltest.demo.manager;

import com.kamiltest.demo.doa.Repo.UserRepo;
import com.kamiltest.demo.doa.model.MyUserDetails;
import com.kamiltest.demo.doa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username != null)
        {
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
