package com.kamiltest.demo.doa.controller;

import com.kamiltest.demo.doa.model.Client;
import com.kamiltest.demo.manager.ClientManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/api/client/")
public class ClientController {
    private ClientManager clientManager;

    @Autowired
    public ClientController(ClientManager clientManager) {
        this.clientManager = clientManager;
    }

    @GetMapping("/getallclients")
    public String GetAll(Model model){
        model.addAttribute("clients",this.clientManager.findAll());
        return "getAllClients";
    }

    @GetMapping("/getbyid")
    public Optional<Client> GetById(@RequestParam Long index){
        return this.clientManager.findById(index);
    }
}
