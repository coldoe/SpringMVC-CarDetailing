package com.kamiltest.demo.doa.model;

import javax.persistence.*;
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
//    @ManyToMany
//    @JoinTable(name = "orders_services",
//    joinColumns = @JoinColumn(name ="order_id"),
//    inverseJoinColumns = @JoinColumn(name = "service_id"))
//    private Set<Service> services;

    //1 order many service
    @ManyToMany
    @JoinTable(name = "orders_services",
            joinColumns = @JoinColumn(name ="order_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id"))
    private Set<ServiceProvidedByCo> servicesProvidedByCo;

    public Order() {
    }

    public Order(Long id, Client client,
    Set<ServiceProvidedByCo> servicesProvidedByCo) {
        Id = id;
        this.client = client;
        this.servicesProvidedByCo = servicesProvidedByCo;
    }

    @Override
    public String toString() {
        return "Order{" +
                "Id=" + Id +
                ", client=" + client +
                ", servicesProvidedByCo=" + servicesProvidedByCo +
                '}';
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<ServiceProvidedByCo> getServicesProvidedByCo() {
        return servicesProvidedByCo;
    }

    public void setServicesProvidedByCo(Set<ServiceProvidedByCo> servicesProvidedByCo) {
        this.servicesProvidedByCo = servicesProvidedByCo;
    }

    public double countNettoValueOfServices()
    {
        double sum = 0;
        for(ServiceProvidedByCo service:this.servicesProvidedByCo)
        {
            sum += service.getNettoPrice();
        }
        return (double) Math.round(sum * 100)/100;
    }

    public double countBruttoValueOfServices()
    {
        double sum = 0;
        for(ServiceProvidedByCo service:this.servicesProvidedByCo)
        {
            sum += 1.18 * service.getNettoPrice();
        }
        return (double) Math.round(sum * 100)/100;
    }

    public double countSumOfTax()
    {
        return (double) Math.round((countBruttoValueOfServices() - countNettoValueOfServices()) * 100)/100;
    }
}
