package com.kamiltest.demo.doa.controller;

import com.kamiltest.demo.doa.model.Client;
import com.kamiltest.demo.doa.viewModels.viewModelCarClient;
import com.kamiltest.demo.manager.CarManager;
import com.kamiltest.demo.manager.ClientManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api/client/")
public class ClientController {
    private ClientManager clientManager;
    private CarManager carManager;

    @Autowired
    public ClientController(ClientManager clientManager, CarManager carManager) {
        this.clientManager = clientManager;
        this.carManager = carManager;
    }

    @GetMapping("/getallclients")
    public String GetAll(Model model){
        model.addAttribute("clients",this.clientManager.findAll());
        return "Client/getAllClients";
    }

    @GetMapping("/getbyid")
    public Optional<Client> GetById(@RequestParam Long index){
        return this.clientManager.findById(index);
    }

    @GetMapping("/updateclient/{id}")
    public String updateClient(@PathVariable Long id, Model model){
        Optional<Client> clientToUpdate = this.clientManager.findById(id);
        if(clientToUpdate.isPresent()){
            model.addAttribute("clientToUpdate",clientToUpdate.get());
            return "Client/updateClient";
        }
        return "redirect:/api/client/getallclients";
    }

    @PutMapping("/updateclient/{id}")
    public String updateClientToDatabase(@ModelAttribute("clientToUpdate")Client client){
        this.clientManager.saveClient(client);
        return "redirect:/api/client/getallclients";
    }

    @DeleteMapping("/deleteclient/{id}")
    public String cascadeDeleteClient(@PathVariable Long id){
        this.clientManager.delete(id);
        return "redirect:/api/client/getallclients";
    }

    @GetMapping("/addclient")
    public String addClientGet(Model model)
    {
        model.addAttribute("clientToAdd",new Client());
        return "Client/addClient";
    }

    @PostMapping("/addclient")
    public String addClientPost(@ModelAttribute("clientToAdd")Client client)
    {
        this.clientManager.saveClient(client);
        return "redirect:/api/client/getallclients";
    }
    //assign car to client
    @GetMapping("/assigncartoclient")
    public String assignCarToClientGetMethod(Model model)
    {
        model.addAttribute("cars",this.carManager.findCarsThatHaveNoOwner());
        model.addAttribute("clients",this.clientManager.findClientsWithoutCars());
        model.addAttribute("viewmodel",new viewModelCarClient());
        return "Client/assignCarToClient";
    }
    @PostMapping("/assigncartoclient")
    public String assignCarToClientPostMethod(
            @ModelAttribute("viewmodel")viewModelCarClient idx)
    {
        this.clientManager.addCarForClient(idx.getIdClient(),idx.getIdCar());
        return "redirect:/api/client/assigncartoclient";
    }
}
