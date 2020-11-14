package com.kamiltest.demo.manager;

import com.kamiltest.demo.doa.Repo.OrderRepo;
import com.kamiltest.demo.doa.Repo.WorkerRepo;
import com.kamiltest.demo.doa.model.Order;
import com.kamiltest.demo.doa.model.Worker;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WorkerManager {
    private WorkerRepo workerRepo;
    private OrderRepo orderRepo;

    public WorkerManager(WorkerRepo workerRepo, OrderRepo orderRepo) {
        this.workerRepo = workerRepo;
        this.orderRepo = orderRepo;
    }

    public Optional<Worker> findById(Long id){
        return this.workerRepo.findById(id);
    }
    public Iterable<Worker> findAll(){
        return this.workerRepo.findAll();
    }
    public Worker save(Worker worker){
        return this.workerRepo.save(worker);
    }
    public void delete(Long id){
        this.workerRepo.deleteById(id);
    }
    public boolean assignOrderForWorker(Long idWorker,Long idOrder)
    {
        Optional<Order> orderToAssign = this.orderRepo.findById(idOrder);
        Optional<Worker> workerOpt = this.workerRepo.findById(idWorker);
        if(orderToAssign.isPresent() && workerOpt.isPresent())
        {
            Worker worker = workerOpt.get();
            Order order = orderToAssign.get();
            worker.getOrdersToDo().add(order);
            this.workerRepo.save(worker);
            return true;
        }
        return false;
    }
    @EventListener(ApplicationReadyEvent.class)
    public void fillDb(){
        //    e.setUtilCalendar(new GregorianCalendar(2019, 6, 18));
//        save((new Worker(10L,"Kamil","Doe","Bialystok","Bia street",new GregorianCalendar(),null)));
//        save((new Worker(20L,"Peter","Do","Bialystok","Dob street",new GregorianCalendar(),null)));
    }

}
