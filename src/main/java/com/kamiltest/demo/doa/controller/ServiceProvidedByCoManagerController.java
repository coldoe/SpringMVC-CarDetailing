package com.kamiltest.demo.doa.controller;

import com.kamiltest.demo.doa.model.ServiceProvidedByCo;
import com.kamiltest.demo.manager.ServiceProvidedByCoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/api/service")
public class ServiceProvidedByCoManagerController {
    private ServiceProvidedByCoManager serviceProvidedByCoManager;

    @Autowired
    public ServiceProvidedByCoManagerController(ServiceProvidedByCoManager serviceProvidedByCoManager) {
        this.serviceProvidedByCoManager = serviceProvidedByCoManager;
    }

    @GetMapping("/getallservices")
    public String getAllServices(Model model)
    {
        model.addAttribute("services",this.serviceProvidedByCoManager.getAllservices());
        return "ServiceProvidedByCo/getAllServices";
    }

    @GetMapping("/addservice")
    public String addServiceGetMethod(Model model)
    {
        model.addAttribute("service",new ServiceProvidedByCo());
        return "ServiceProvidedByCo/addService";
    }
    @PostMapping("/addservice")
    public String addServicePostMethod(@Valid @ModelAttribute("service")ServiceProvidedByCo service,
                                       BindingResult result)
    {
        if(result.hasErrors())
        {
            return "ServiceProvidedByCo/addService";
        }
        this.serviceProvidedByCoManager.saveService(service);
        return "redirect:/api/service/getallservices";
    }
    @DeleteMapping("/deleteservice/{id}")
    public String deleteService(@PathVariable Long id)
    {
        Optional<ServiceProvidedByCo> serviceToDelete = this.serviceProvidedByCoManager.findServiceById(id);
        if(serviceToDelete.isPresent())
        {
            this.serviceProvidedByCoManager.deleteServiceProvidedByCo(id);
        }
        return "redirect:/api/service/getallservices";
    }
    @GetMapping("/updateservice/{id}")
    public String updateServiceGetMethod(@PathVariable Long id,Model model)
    {
        Optional<ServiceProvidedByCo> serviceToUpdate = this.serviceProvidedByCoManager.findServiceById(id);
        if(serviceToUpdate.isPresent())
        {
            model.addAttribute("serviceToUpdate",serviceToUpdate.get());
            return "ServiceProvidedByCo/updateService";
        }
        return "redirect:/api/service/getallservices";
    }
    @PutMapping("/updateservice/{id}")
    public String updateServicePutMethod(@Valid @ModelAttribute("serviceToUpdate") ServiceProvidedByCo service,
                                         BindingResult result)
    {
        if(result.hasErrors())
        {
            return "ServiceProvidedByCo/updateService";
        }
        this.serviceProvidedByCoManager.saveService(service);
        return "redirect:/api/service/getallservices";
    }
}
