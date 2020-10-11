package com.kamiltest.demo.manager;

import com.kamiltest.demo.doa.Repo.CarRepo;
import com.kamiltest.demo.doa.model.Car;
import org.springframework.stereotype.Service;

@Service
public class CarManager {
    private CarRepo carRepo;

    public CarManager(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    public Iterable<Car> findAll(){
        return this.carRepo.findAll();
    }
}
