package com.kamiltest.demo.doa.viewModels;

import java.util.Set;

public class addNewOrder {
    private Long idClient;
    private Set<Long> services;

    public addNewOrder() {
    }

    public addNewOrder(Long idClient, Set<Long> services) {
        this.idClient = idClient;
        this.services = services;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public Set<Long> getServices() {
        return services;
    }

    public void setServices(Set<Long> services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return "addNewOrder{" +
                "idClient=" + idClient +
                ", services=" + services +
                '}';
    }

    public void addToSet(Long id){
        this.services.add(id);
    }
    public void removeFromSet(Long id)
    {
        this.services.remove(id);
    }
}
