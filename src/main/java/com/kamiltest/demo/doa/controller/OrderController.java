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

    @GetMapping("/getspecificorder/{id}")
    public String findSpecificOrderById(@PathVariable Long id,Model model)
    {
        Optional<Order> orderCheck = this.orderManager.findOrderById(id);
        if(orderCheck.isPresent())
        {
            //a lot of list to print
            model.addAttribute("order",orderCheck.get());
            return "Order/getSpecificOrder";
        }
        return "redirect:/api/order/getallorders";
    }
}
