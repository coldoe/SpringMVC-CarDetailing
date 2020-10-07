package com.kamiltest.demo.doa.model;

import javax.persistence.*;
import java.util.Calendar;

//add entity and check connection with database
@Entity
public class Worker {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    private String surname;
    private String City;
    private String Street;
    @Temporal(TemporalType.DATE)
    private Calendar utilCalendar;
//    e.setUtilCalendar(new GregorianCalendar(2019, 6, 18));

    public Worker() {
    }

    public Worker(Long id, String name, String surname, String city, String street, Calendar utilCalendar) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        City = city;
        Street = street;
        this.utilCalendar = utilCalendar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Calendar getUtilCalendar() {
        return utilCalendar;
    }

    public void setUtilCalendar(Calendar utilCalendar) {
        this.utilCalendar = utilCalendar;
    }
}
