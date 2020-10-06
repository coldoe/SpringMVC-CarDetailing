package com.kamiltest.demo;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Worker {
    private long id;
    private String name;
    private String surname;
    private String City;
    private String Street;
    private Date StartDate;

    public Worker() {
    }

    public Worker(long id, String name, String surname, String city, String street, Date startDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        City = city;
        Street = street;
        StartDate = startDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date startDate) {
        StartDate = startDate;
    }
}
