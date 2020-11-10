package com.kamiltest.demo.manager;

import com.kamiltest.demo.doa.Repo.ServiceProvidedByCoRepo;
import com.kamiltest.demo.doa.model.ServiceProvidedByCo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceProvidedByCoManager {
    private ServiceProvidedByCoRepo serviceProvidedByCoRepo;

    public ServiceProvidedByCoManager(ServiceProvidedByCoRepo serviceProvidedByCoRepo) {
        this.serviceProvidedByCoRepo = serviceProvidedByCoRepo;
    }

    public Iterable<ServiceProvidedByCo> getAllservices()
    {
        return this.serviceProvidedByCoRepo.findAll();
    }

    public Optional<ServiceProvidedByCo> findServiceById(Long id){
        return this.serviceProvidedByCoRepo.findById(id);
    }

    public ServiceProvidedByCo saveService(ServiceProvidedByCo service)
    {
        return this.serviceProvidedByCoRepo.save(service);
    }

    public boolean deleteServiceProvidedByCo(Long id)
    {
        try{
            this.serviceProvidedByCoRepo.deleteById(id);
            return true;
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
            return false;
        }

    }
}
