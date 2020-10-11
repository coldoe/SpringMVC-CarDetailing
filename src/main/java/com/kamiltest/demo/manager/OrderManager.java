package com.kamiltest.demo.manager;

import com.kamiltest.demo.doa.Repo.OrderRepo;
import com.kamiltest.demo.doa.model.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderManager {
    private OrderRepo orderRepo;

    public OrderManager(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public Iterable<Order> findAll(){
        return this.orderRepo.findAll();
    }


}
