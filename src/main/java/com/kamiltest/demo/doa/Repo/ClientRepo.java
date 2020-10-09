package com.kamiltest.demo.doa.Repo;

import com.kamiltest.demo.doa.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends CrudRepository<Client,Long> {
}
