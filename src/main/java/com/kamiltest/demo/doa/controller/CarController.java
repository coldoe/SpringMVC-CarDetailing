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

    @GetMapping("/addcar")
    public String addCar(Model model){
        model.addAttribute("car",new Car());
        return "addCar";
    }

    @PostMapping("/addcar")
    public String addCarPost(@ModelAttribute("car")Car car){
        this.carManager.updateCar(car);
        return "redirect:/api/car/getallcars";
    }

    @DeleteMapping("/deletecar/{id}")
    public String deleteCar(@PathVariable Long id)
    {
        Optional<Car> carToDelete = this.carManager.findCarById(id);
        if(carToDelete.isPresent())
        {
            if(carToDelete.get().getClient() != null)
            {
                this.clientManager.deleteCarForClientByCarId(id);
            }
            else{
            this.carManager.deleteCarById(id);
            }
        }
        return "redirect:/api/car/getallcars";
    }
    @GetMapping("/updatecar/{id}")
    public String getCarToUpdate(@PathVariable Long id, Model model)
    {
        Optional<Car> carToUpdate = this.carManager.findCarById(id);
        if(carToUpdate.isPresent()){
            model.addAttribute("carToUpdate", carToUpdate.get());
            return "updateCar";
        }
        return "redirect:/api/car/getallcars";
    }
    @PutMapping("/updatecar/{id}")
    public String updateCarFromView(@ModelAttribute("carToUpdate")Car car)
    {
        this.carManager.updateCar(car);
        return "redirect:/api/car/getallcars";
    }

}
