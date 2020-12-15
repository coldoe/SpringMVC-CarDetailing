package com.kamiltest.demo.manager;

import com.kamiltest.demo.doa.Repo.RoleRepo;
import com.kamiltest.demo.doa.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class RoleService implements CommandLineRunner {
    @Autowired
    private RoleRepo roleRepo;

    public Iterable<Role> findAll(){return this.roleRepo.findAll();}
    public Optional<Role> findById(Long id){return this.roleRepo.findById(id);}

    @Override
    public void run(String... args) throws Exception {
        try{
            if(StreamSupport
                    .stream(this.roleRepo.findAll().spliterator(),false)
                    .count() == 0){
                this.roleRepo.save(new Role(1L,"ADMIN"));
                this.roleRepo.save(new Role(2L,"MODERATOR"));
                this.roleRepo.save(new Role(3L,"WORKER"));
                System.out.println("I've added 3 roles to the database");
            }
        }catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
    }
}
