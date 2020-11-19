package com.kamiltest.demo.doa.Repo;

import com.kamiltest.demo.doa.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends CrudRepository<Role,Long> {
}
