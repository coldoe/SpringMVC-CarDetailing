package com.kamiltest.demo.manager;

import com.kamiltest.demo.doa.Repo.OrderRepo;
import com.kamiltest.demo.doa.model.Order;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderManager {
    private OrderRepo orderRepo;

    public OrderManager(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public Iterable<Order> findAll(){
        return this.orderRepo.findAll();
    }
    public Optional<Order> findOrderById(Long id) { return this.orderRepo.findById(id); }
    public Order saveOrder(Order order) { return this.orderRepo.save(order);}
    public boolean deleteOrderById(Long id)
    {
        try{
            this.orderRepo.deleteById(id);
            return true;

        }catch(Exception ex)
        {
            System.out.println(ex.toString());
            return false;
        }
    }


}
