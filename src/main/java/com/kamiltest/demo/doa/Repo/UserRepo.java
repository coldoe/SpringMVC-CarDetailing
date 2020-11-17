package com.kamiltest.demo.doa.Repo;

import com.kamiltest.demo.doa.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepo extends CrudRepository<User,Long> {
    @Query(value = "SELECT U FROM USERS WHERE U.USERNAME = :username")
    Optional<User> findUserByUsername(@Param("username")String username);
}
