package com.kamiltest.demo.doa.controller;

import com.kamiltest.demo.doa.model.Client;
import com.kamiltest.demo.doa.viewModels.viewModelCarClient;
import com.kamiltest.demo.manager.CarManager;
import com.kamiltest.demo.manager.ClientManager;
import com.kamiltest.demo.manager.OrderManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/api/client/")
public class ClientController {
    private ClientManager clientManager;
    private CarManager carManager;
    private OrderManager orderManager;

    public ClientController(ClientManager clientManager, CarManager carManager, OrderManager orderManager) {
        this.clientManager = clientManager;
        this.carManager = carManager;
        this.orderManager = orderManager;
    }

    @GetMapping("/getallclients")
    public String GetAll(Model model){
        model.addAttribute("clients",this.clientManager.findAll());
        return "Client/getAllClients";
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
    public String updateClientToDatabase(@Valid @ModelAttribute("clientToUpdate")Client client,
                                         BindingResult result){
        if(result.hasErrors())
        {
            return "Client/updateClient";
        }
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
    public String addClientPost(@Valid @ModelAttribute("clientToAdd")Client client,
                                BindingResult result)
    {
        if(result.hasErrors())
        {
            return "Client/addClient";
        }
        this.clientManager.saveClient(client);
        return "redirect:/api/client/getallclients";
    }

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
            Model model,
            @Valid @ModelAttribute("viewmodel")viewModelCarClient idx,
            BindingResult result)
    {
        if(result.hasErrors())
        {
            model.addAttribute("cars",this.carManager.findCarsThatHaveNoOwner());
            model.addAttribute("clients",this.clientManager.findClientsWithoutCars());
            model.addAttribute("viewmodel",new viewModelCarClient());
            model.addAttribute("notValidated",result.getFieldError().getDefaultMessage());
            return "Client/assignCarToClient";
        }
        this.clientManager.addCarForClient(idx.getIdClient(),idx.getIdCar());
        return "redirect:/api/client/assigncartoclient";
    }
}
