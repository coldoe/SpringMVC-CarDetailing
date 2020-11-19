package com.kamiltest.demo.doa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/")
public class HomeController {

    @Autowired
    public HomeController() {
    }

    @GetMapping("/home")
    public String getAllCars(){
        return "Sharing/home";
    }

    @GetMapping("/403")
    public String forbiddenHandler(){return "Sharing/403";}

}
