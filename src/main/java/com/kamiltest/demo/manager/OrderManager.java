package com.kamiltest.demo.manager;

import com.kamiltest.demo.doa.Repo.OrderRepo;
import com.kamiltest.demo.doa.model.Client;
import com.kamiltest.demo.doa.model.Order;
import com.kamiltest.demo.doa.model.ServiceProvidedByCo;
import com.kamiltest.demo.doa.viewModels.addNewOrder;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class OrderManager {
    private OrderRepo orderRepo;
    private ClientManager clientManager;
    private ServiceProvidedByCoManager serviceProvidedByCoManager;

    public OrderManager(OrderRepo orderRepo, ClientManager clientManager, ServiceProvidedByCoManager serviceProvidedByCoManager) {
        this.orderRepo = orderRepo;
        this.clientManager = clientManager;
        this.serviceProvidedByCoManager = serviceProvidedByCoManager;
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
    public Iterable<Order> getAllOrdersNotAssignToWorker()
    {
        return this.orderRepo.getAllNotAssignOrdersToWorker();
    }
    public boolean addNewOrder(addNewOrder order,String[] services)
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
                this.saveOrder(orderToSave);
                return true;
            }
        }
        return false;
    }


}
