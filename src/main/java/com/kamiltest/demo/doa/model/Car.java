package com.kamiltest.demo.doa.model;

import javax.persistence.*;

@Entity
public class Car {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long Id;
    private String mark;
    private String model;
    private int year;
    @OneToOne
    @PrimaryKeyJoinColumn
    private Client client;

    public Car() {
    }

    public Car(Long id, String mark, String model, int year, Client client) {
        Id = id;
        this.mark = mark;
        this.model = model;
        this.year = year;
        this.client = client;
    }

    @Override
    public String toString() {
        return "Car{" +
                "Id=" + Id +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", client=" + client +
                '}';
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
