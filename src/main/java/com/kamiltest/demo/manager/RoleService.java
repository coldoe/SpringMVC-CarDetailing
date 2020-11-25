package com.kamiltest.demo.manager;

import com.kamiltest.demo.doa.Repo.RoleRepo;
import com.kamiltest.demo.doa.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private RoleRepo roleRepo;

    public Iterable<Role> findAll(){return this.roleRepo.findAll();}
    public Optional<Role> findById(Long id){return this.roleRepo.findById(id);}
}
