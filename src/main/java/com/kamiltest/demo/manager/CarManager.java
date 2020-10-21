package com.kamiltest.demo.manager;

import com.kamiltest.demo.doa.Repo.CarRepo;
import com.kamiltest.demo.doa.model.Car;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarManager {
    private CarRepo carRepo;

    public CarManager(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    //get
    public Iterable<Car> findAll(){
        return this.carRepo.findAll();
    }
    public Optional<Car> findCarById(Long id) {return this.carRepo.findById(id);}
    //add
    //edit
    public Car updateCar(Car car){
        return this.carRepo.save(car);
    }
    //delete
    public boolean deleteCarById(Long id){
        try{
            this.carRepo.deleteById(id);
            return true;
        }
        catch(Exception ex){
            System.out.println(ex.toString());
            return false;
        }
    }
}
