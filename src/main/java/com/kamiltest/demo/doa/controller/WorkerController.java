package com.kamiltest.demo.doa.controller;

import com.kamiltest.demo.doa.model.Worker;
import com.kamiltest.demo.manager.WorkerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/worker/")
public class WorkerController {
    private WorkerManager workerManager;

    @Autowired
    public WorkerController(WorkerManager workerManager) {
        this.workerManager = workerManager;
    }

    @GetMapping("/getall")
    public Iterable<Worker> GetAll(){
        return this.workerManager.findAll();
    }

    @GetMapping("/getbyid")
    public Optional<Worker> GetById(@RequestParam Long index){
        return workerManager.findById(index);
    }
    @PostMapping("/addWorker")
    public Worker AddWorker(@RequestBody Worker worker){
        return this.workerManager.save(worker);
    }
    @PutMapping("/editworker")
    public Worker EditWorker(@RequestBody Worker worker){
        return this.workerManager.save(worker);
    }

    @DeleteMapping("/deleteworker")
    public void DeleteWorker(@RequestParam Long index)
    {
        this.workerManager.delete(index);
    }
}
