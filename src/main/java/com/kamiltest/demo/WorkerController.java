package com.kamiltest.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/worker/")
public class WorkerController {
    private List<Worker> workers;

    public WorkerController() {
        this.workers = new ArrayList<>();
        workers.add(new Worker(1L,"Kamil","Doe","Bialystok","Kurla street",new Date()));
    }

    @GetMapping("/getall")
    public List<Worker> GetAll(){
        return workers;
    }

    @GetMapping()
    public Worker GeById(@RequestParam int index){
        Optional<Worker> option =  workers.stream().filter(element -> element.getId() == index).findFirst();
        return option.get();
    }
}
