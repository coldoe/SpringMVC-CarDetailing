package com.kamiltest.demo.doa.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class ServiceProvidedByCo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PrimaryKeyJoinColumn
    private Long Id;

    @NotNull(message = "Required")
    @Size(min = 3, max = 255, message = "It must be between 3 and 255 characters")
    private String name;

    @NotNull(message = "Required")
    @Size(min = 3, max = 255, message = "It must be between 3 and 255 characters")
    private String description;

    @NotNull(message = "Required")
    @Size(min = 3, max = 255, message = "It must be between 3 and 255 characters")
    private int nettoPrice;

    @NotNull(message = "Required")
    @Size(min = 3, max = 255, message = "It must be between 3 and 255 characters")
    private String additionalInfo;

    @NotNull(message = "Required")
    @Size(min = 3, max = 255, message = "It must be between 3 and 255 characters")
    @ManyToMany(mappedBy = "servicesProvidedByCo")
    private Set<Order> orders;

    public ServiceProvidedByCo() {
    }

    public ServiceProvidedByCo(Long id, String name,
                               String description, int nettoPrice,
                               String additionalInfo, Set<Order> orders) {
        Id = id;
        this.name = name;
        this.description = description;
        this.nettoPrice = nettoPrice;
        this.additionalInfo = additionalInfo;
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "ServiceProvidedByCo{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", nettoPrice=" + nettoPrice +
                ", additionalInfo='" + additionalInfo + '\'' +
                ", orders=" + orders +
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

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
