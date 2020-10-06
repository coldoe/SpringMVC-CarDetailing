package com.kamiltest.demo;

import org.springframework.web.bind.annotation.*;

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
        workers.add(new Worker(2L,"Kamil","Doe","Bialystok","Kurla street",new Date()));
        workers.add(new Worker(3L,"Kamil","Doe","Bialystok","Kurla street",new Date()));
    }

    @GetMapping("/getall")
    public List<Worker> GetAll(){
        return workers;
    }

    @GetMapping("/getbyid")
    public Worker GeById(@RequestParam int index){
        Optional<Worker> option =  workers.stream().filter(element -> element.getId() == index).findFirst();
        if(option.isPresent()){
            return option.get();
        }
        return null;
    }
    @PostMapping("/addworker")
    public Worker AddWorker(@RequestBody Worker worker){
        long id = this.workers.get(this.workers.size()-1).getId();
        id++;
        worker.setId(id);
        this.workers.add(worker);
        return worker;
    }
    //edit and delete 
}
