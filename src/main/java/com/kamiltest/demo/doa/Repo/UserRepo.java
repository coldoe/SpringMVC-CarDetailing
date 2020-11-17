package com.kamiltest.demo.doa.Repo;

import com.kamiltest.demo.doa.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepo extends CrudRepository<User,Long> {
    @Query(value = "select * from users u where u.username = :username",nativeQuery = true)
    Optional<User> findUserByUsername(@Param("username")String username);
}
