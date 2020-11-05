package com.kamiltest.demo.doa.Repo;

import com.kamiltest.demo.doa.model.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CarRepo extends CrudRepository<Car,Long> {
    @Query(value = "select *\n" +
            " from car c\n" +
            " where not exists(select * from client k where k.car_id = c.id); ",nativeQuery = true)
    Collection<Car> allCarsThatHaveNoOwner();
}
