package com.kamiltest.demo.manager;

import com.kamiltest.demo.doa.Repo.ClientRepo;
import com.kamiltest.demo.doa.model.Client;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientManager {
    private ClientRepo clientRepo;

    public ClientManager(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    public Optional<Client> findById(Long id){
        return this.clientRepo.findById(id);
    }

    public Iterable<Client> findAll(){
        return this.clientRepo.findAll();
    }

    public Client saveClient(Client client){
        return this.clientRepo.save(client);
    }

    public void delete(Long id){
        this.clientRepo.deleteById(id);
    }
}
