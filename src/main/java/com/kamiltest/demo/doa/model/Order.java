package com.kamiltest.demo.doa.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @PrimaryKeyJoinColumn
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    //1 order 1 client 1-1?
    @OneToOne(targetEntity = Client.class)
    private Client client;
    //1 order many service
    @ManyToMany
    @JoinTable(name = "orders_services",
    joinColumns = @JoinColumn(name ="order_id"),
    inverseJoinColumns = @JoinColumn(name = "service_id"))
    private Set<Service> services;

    public Order() {
    }

    public Order(Long id, Client client, Set<Service> services) {
        Id = id;
        this.client = client;
        this.services = services;
    }

    @Override
    public String toString() {
        return "Order{" +
                "Id=" + Id +
                ", client=" + client +
                ", services=" + services +
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

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(Id, order.Id) &&
                Objects.equals(client, order.client) &&
                Objects.equals(services, order.services);
    }
}
