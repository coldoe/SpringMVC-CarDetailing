package com.kamiltest.demo.doa.Repo;

import com.kamiltest.demo.doa.model.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ClientRepo extends CrudRepository<Client,Long> {
    @Query(value = "select *\n" +
            " from client c\n" +
            " where c.car_id is null;",nativeQuery = true)
    Collection<Client> getAllClientsThatHaveNoCars();
    @Query(value = "select *\n" +
            " from client c\n" +
            " where c.car_id is not null;",nativeQuery = true)
    Collection<Client> getAllClientsThatHaveCars();
}
