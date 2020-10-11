package com.kamiltest.demo.doa.controller;

import com.kamiltest.demo.doa.model.Order;
import com.kamiltest.demo.manager.OrderManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    private OrderManager orderManager;

    public OrderController(OrderManager orderManager) {
        this.orderManager = orderManager;
    }

    @GetMapping("/getall")
    public Iterable<Order> getAll(){
        return this.orderManager.findAll();
    }
}
