package com.kamiltest.demo.manager;

import com.kamiltest.demo.doa.Repo.WorkerRepo;
import com.kamiltest.demo.doa.model.Worker;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.GregorianCalendar;
import java.util.Optional;

@Service
public class WorkerManager {
    private WorkerRepo workerRepo;

    public WorkerManager(WorkerRepo workerRepo) {
        this.workerRepo = workerRepo;
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

    @EventListener(ApplicationReadyEvent.class)
    public void fillDb(){
        //    e.setUtilCalendar(new GregorianCalendar(2019, 6, 18));
        save((new Worker(1L,"Kamil","Doe","Bialystok","Kurla street",new GregorianCalendar())));
        save((new Worker(2L,"Peter","Do","Bialystok","Do",new GregorianCalendar())));
    }

}
