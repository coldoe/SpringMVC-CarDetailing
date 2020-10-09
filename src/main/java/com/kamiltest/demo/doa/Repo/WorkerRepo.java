package com.kamiltest.demo.doa.Repo;

import com.kamiltest.demo.doa.model.Worker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepo extends CrudRepository<Worker,Long> {
}
