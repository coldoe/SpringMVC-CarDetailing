package com.kamiltest.demo.doa.controller;

import com.kamiltest.demo.doa.model.Order;
import com.kamiltest.demo.manager.OrderManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/api/order")
public class OrderController {
    private OrderManager orderManager;

    public OrderController(OrderManager orderManager) {
        this.orderManager = orderManager;
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
    //add
    //update
    //delete
}
