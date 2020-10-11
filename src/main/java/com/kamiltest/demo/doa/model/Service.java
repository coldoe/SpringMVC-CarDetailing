package com.kamiltest.demo.doa.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Service {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PrimaryKeyJoinColumn
    private Long Id;

    private String name;
    private String description;
    private int nettoPrice;
    private String additionalInfo;
    @ManyToMany(mappedBy = "services")
    private Set<Order> orders;

    public Service() {
    }

    public Service(Long id, String name, String description, int nettoPrice, String additionalInfo) {
        Id = id;
        this.name = name;
        this.description = description;
        this.nettoPrice = nettoPrice;
        this.additionalInfo = additionalInfo;
    }

    @Override
    public String toString() {
        return "Service{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", nettoPrice=" + nettoPrice +
                ", additionalInfo='" + additionalInfo + '\'' +
                '}';
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNettoPrice() {
        return nettoPrice;
    }

    public void setNettoPrice(int nettoPrice) {
        this.nettoPrice = nettoPrice;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return nettoPrice == service.nettoPrice &&
                Objects.equals(Id, service.Id) &&
                Objects.equals(name, service.name) &&
                Objects.equals(description, service.description) &&
                Objects.equals(additionalInfo, service.additionalInfo) &&
                Objects.equals(orders, service.orders);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(Id, name, description, nettoPrice, additionalInfo, orders);
//    }
}
