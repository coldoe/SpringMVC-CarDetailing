package com.kamiltest.demo.doa.controller;

import com.kamiltest.demo.doa.model.Client;
import com.kamiltest.demo.doa.model.Order;
import com.kamiltest.demo.doa.model.ServiceProvidedByCo;
import com.kamiltest.demo.doa.viewModels.addNewOrder;
import com.kamiltest.demo.manager.ClientManager;
import com.kamiltest.demo.manager.OrderManager;
import com.kamiltest.demo.manager.ServiceProvidedByCoManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/api/order")
public class OrderController {
    private OrderManager orderManager;
    private ServiceProvidedByCoManager serviceProvidedByCoManager;
    private ClientManager clientManager;

    public OrderController(OrderManager orderManager, ServiceProvidedByCoManager serviceProvidedByCoManager, ClientManager clientManager) {
        this.orderManager = orderManager;
        this.serviceProvidedByCoManager = serviceProvidedByCoManager;
        this.clientManager = clientManager;
    }

    @GetMapping("/getallorders")
    public String getAllOrderGetMethod(Model model)
    {
        model.addAttribute("orders",this.orderManager.findAll());
        return "Order/getAllOrders";
    }

    @GetMapping("/getspecificorder/{who}/{id}")
    public String findSpecificOrderById(@PathVariable Long id,
                                        @PathVariable String who,
                                        Model model)
    {
        Optional<Order> orderCheck = this.orderManager.findOrderById(id);
        if(orderCheck.isPresent())
        {
            model.addAttribute("order",orderCheck.get());
            if(who.equals("client"))
            {
                model.addAttribute("who","client");
                return "Order/getSpecificOrder";
            }
            else if(who.equals("worker"))
            {
                model.addAttribute("who","worker");
                return "Order/getSpecificOrder";
            }
            else
                return "redirect:/api/order/getallorders";
        }
        return "redirect:/api/order/getallorders";
    }
    //add i guess special view model to store id client, list of services,
    @GetMapping("/addorder")
    public String addNewOrderGetMethod(Model model)
    {
        model.addAttribute("valuesToPass", new addNewOrder());
        model.addAttribute("services", this.serviceProvidedByCoManager.getAllservices());
        model.addAttribute("clients",this.clientManager.findClientsWithCars());
        return "Order/addNewOrder";
    }
    @PostMapping("/addorder")
    public String addNewOrderPostMethod(@ModelAttribute("valuesToPass")addNewOrder order,
                                        @RequestParam(value = "servicesTable" , required = false) String[] services )
    {
        order.setServices(new LinkedHashSet<Long>());
        for(String g : services)
        {
            order.addToSet(Long.parseLong(g));
        }
        if(order.getIdClient() != null && order.getServices() != null && order.getServices().size() > 0)
        {
            Optional<Client> client = this.clientManager.findById(order.getIdClient());
            Set<ServiceProvidedByCo> servicesSet = new LinkedHashSet<>();
            for(Long idService : order.getServices())
            {
                servicesSet.add(this.serviceProvidedByCoManager.findServiceById(idService).get());
            }
            if(client.isPresent())
            {
                Order orderToSave = new Order();
                orderToSave.setClient(client.get());
                orderToSave.setServicesProvidedByCo(servicesSet);
                orderToSave.setDone(false);
                orderToSave.setPayed(false);
                this.orderManager.saveOrder(orderToSave);
            }
        }
        return "redirect:/api/order/getallorders";
    }
    //update i guess without changing etc cause too much
    @PutMapping("/setboolean/{field}/{id}")
    public String updateOrderBasedOnFieldPutMethod(@PathVariable String field,
                                                   @PathVariable Long id)
    {
        Optional<Order> orderToUpdateFieldBool = this.orderManager.findOrderById(id);
        if(orderToUpdateFieldBool.isPresent())
        {
            Order order = orderToUpdateFieldBool.get();
            if(field.equals("done"))
            {
                order.setDone(!order.getisDone());
                this.orderManager.saveOrder(order);
            }
            else if(field.equals("payed"))
            {
                order.setPayed(!order.getisPayed());
                this.orderManager.saveOrder(order);
            }
        }
        return "redirect:/api/order/getallorders";
    }
    //delete
    @DeleteMapping("/deleteorder/{id}")
    public String deleteOrder(@PathVariable Long id)
    {
        Optional<Order> orderToDelete = this.orderManager.findOrderById(id);
        if(orderToDelete.isPresent())
        {
            this.orderManager.deleteOrderById(id);
        }
        return "redirect:/api/order/getallorders";
    }
}
