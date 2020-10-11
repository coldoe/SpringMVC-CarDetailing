package com.kamiltest.demo.doa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.PrimaryKeyJoinColumn;

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
}
