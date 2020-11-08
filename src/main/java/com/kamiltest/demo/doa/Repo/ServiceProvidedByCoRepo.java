package com.kamiltest.demo.doa.Repo;

import com.kamiltest.demo.doa.model.ServiceProvidedByCo;
import org.springframework.data.repository.CrudRepository;

public interface ServiceProvidedByCoRepo
        extends CrudRepository<ServiceProvidedByCo,Long> {
}
