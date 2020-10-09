package com.kamiltest.demo.doa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;

@Entity
public class Client {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long Id;
    private String name;
    private String surname;
    private String contactNumber;
    @OneToOne(cascade = CascadeType.ALL)
    private Car car;

    public Client() {
    }

    public Client(Long id, String name, String surname, String contactNumber) {
        Id = id;
        this.name = name;
        this.surname = surname;
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "Client{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", car=" + car +
                '}';
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
