package com.kamiltest.demo.doa.controller;

import com.kamiltest.demo.doa.model.Car;
import com.kamiltest.demo.manager.CarManager;
import com.kamiltest.demo.manager.ClientManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api/car/")
public class CarController {
    private CarManager carManager;
    private ClientManager clientManager;

    @Autowired
    public CarController(CarManager carManager, ClientManager clientManager) {
        this.carManager = carManager;
        this.clientManager = clientManager;
    }

    @GetMapping("/getallcars")
    public String getAllCars(Model model){
        Iterable<Car> cars = this.carManager.findAll();
        model.addAttribute("cars",cars);
        return "getAllCars";
    }
    //add car
    @GetMapping("/addcar")
    public String addCar(Model model){
        model.addAttribute("car",new Car());
        return "addCar";
    }
    //that should be also update?
    @PostMapping("/addcar")
    public String addCarPost(@ModelAttribute("car")Car car){
        this.carManager.updateCar(car);
        return "redirect:/api/car/getallcars";
    }
    //delete car
    //if car has client it wont delete why?
    @DeleteMapping("/deletecar/{id}")
    public String deleteCar(@PathVariable Long id)
    {
        Optional<Car> carToDelete = this.carManager.findCarById(id);
        if(carToDelete.isPresent())
        {
            if(carToDelete.get().getClient() != null)
            {
                this.clientManager.deleteCarForClientByCarId(id);
                this.carManager.deleteCarById(id);
            }
            else{
            this.carManager.deleteCarById(id);
            }
        }
        return "redirect:/api/car/getallcars";
    }

}
