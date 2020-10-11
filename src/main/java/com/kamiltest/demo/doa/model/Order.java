package com.kamiltest.demo.doa.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @PrimaryKeyJoinColumn
    private Long Id;
    //1 order 1 client 1-1?
    @OneToOne(targetEntity = Client.class)
    private Client client;
    //1 order many service
//    private Set<Service> services;

    public Order() {
    }

    public Order(Long id, Client client) {
        Id = id;
        this.client = client;
    }

    @Override
    public String toString() {
        return "Order{" +
                "Id=" + Id +
                ", client=" + client +
                '}';
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    @JsonManagedReference
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

//    public Set<Service> getServices() {
//        return services;
//    }
//
//    public void setServices(Set<Service> services) {
//        this.services = services;
//    }
}
