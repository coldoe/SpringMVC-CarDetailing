package com.kamiltest.demo.manager;

import com.kamiltest.demo.doa.Repo.UserRepo;
import com.kamiltest.demo.doa.model.MyUserDetails;
import com.kamiltest.demo.doa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

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
}
