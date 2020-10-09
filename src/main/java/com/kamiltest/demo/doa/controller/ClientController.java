package com.kamiltest.demo.doa.controller;

import com.kamiltest.demo.doa.model.Client;
import com.kamiltest.demo.manager.ClientManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/client/")
public class ClientController {
    private ClientManager clientManager;

    @Autowired
    public ClientController(ClientManager clientManager) {
        this.clientManager = clientManager;
    }

    //something bad happens nesting objects in json
    @GetMapping("/getallclients")
    public Iterable<Client> GetAll(){
        return this.clientManager.findAll();
    }

    @GetMapping("/getbyid")
    public Optional<Client> GetById(@RequestParam Long index){
        return this.clientManager.findById(index);
    }
}
