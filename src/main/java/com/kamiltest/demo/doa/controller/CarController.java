package com.kamiltest.demo.doa.controller;

import com.kamiltest.demo.doa.model.Car;
import com.kamiltest.demo.manager.CarManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/car/")
public class CarController {
    private CarManager carManager;

    @Autowired
    public CarController(CarManager carManager) {
        this.carManager = carManager;
    }
    //update delete car
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
    @PostMapping("/addcar")
    public String addCarPost(@ModelAttribute("car")Car car){
        //car without client
        this.carManager.updateCar(car);
        return "redirect:/getallcars";
    }

}
