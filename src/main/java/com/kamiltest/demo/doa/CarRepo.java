package com.kamiltest.demo.doa;

import com.kamiltest.demo.doa.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepo extends CrudRepository<Car,Long> {
}
