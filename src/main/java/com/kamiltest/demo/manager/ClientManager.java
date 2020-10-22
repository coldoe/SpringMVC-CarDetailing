package com.kamiltest.demo.manager;

import com.kamiltest.demo.doa.Repo.ClientRepo;
import com.kamiltest.demo.doa.model.Car;
import com.kamiltest.demo.doa.model.Client;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ClientManager {
    private ClientRepo clientRepo;
    private CarManager carManager;

    public ClientManager(ClientRepo clientRepo, CarManager carManager) {
        this.clientRepo = clientRepo;
        this.carManager = carManager;
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

    //delete Car for client
    public boolean deleteCarForClient(Long idClient){
        try{
            Optional<Client> client = this.findById(idClient);
            if(client.isPresent()){
                Optional<Car> carToDelete = this.carManager.findCarById(client.get().getCar().getId());
                if(carToDelete.isPresent()){
                    this.carManager.deleteCarById(carToDelete.get().getId());
                    return true;
                }
                return false;
            }
            return false;
        }
        catch(Exception ex){
            System.out.println(ex.toString());
            return false;
        }
    }
    //update car for client
    //add car for client
    public Client updateOrAddCarForClient(Long idClient,Car carToUpdateOrAdd){
        try{
            Optional<Client> client = this.findById(idClient);
            if(client.isPresent() && carToUpdateOrAdd != null){
                Client clientToUpdate = client.get();
                clientToUpdate.setCar(carToUpdateOrAdd);
                this.clientRepo.save(clientToUpdate);
                return clientToUpdate;
            }
            return null;
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
            return null;
        }
    }
    public void deleteCarForClientByCarId(Long idCar)
    {
        Iterable<Client> clients = this.clientRepo.findAll();
        List<Client> listClientWithCar = StreamSupport.stream(clients.spliterator(),false).
                                        filter(c -> Long.compare(c.getCar().getId() ,idCar) == 0).collect(Collectors.toList());
        Client client = listClientWithCar.get(0);
        client.setCar(null);
        this.clientRepo.save(client);
    }
}