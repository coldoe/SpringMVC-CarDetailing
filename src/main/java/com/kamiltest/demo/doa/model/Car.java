package com.kamiltest.demo.doa.model;import com.fasterxml.jackson.annotation.JsonBackReference;import javax.persistence.*;@Entitypublic class Car {    @GeneratedValue(strategy = GenerationType.IDENTITY)    @Id    private Long Id;    private String mark;    private String model;    private int year;//    @OneToOne(targetEntity = Client.class)//    @PrimaryKeyJoinColumn    @OneToOne(mappedBy = "car")    private Client client;    public Car() {    }    public Car(Long id, String mark, String model, int year, Client client) {        Id = id;        this.mark = mark;        this.model = model;        this.year = year;        this.client = client;    }    @Override    public String toString() {//        return "Car{" +//                "Id=" + Id +//                ", mark='" + mark + '\'' +//                ", model='" + model + '\'' +//                ", year=" + year +//                ", client=" + client +//                '}';        return null;    }    public Long getId() {        return Id;    }    public void setId(Long id) {        Id = id;    }    public String getMark() {        return mark;    }    public void setMark(String mark) {        this.mark = mark;    }    public String getModel() {        return model;    }    public void setModel(String model) {        this.model = model;    }    public int getYear() {        return year;    }    public void setYear(int year) {        this.year = year;    }    //to prevent recursion    @JsonBackReference//    @JsonManagedReference    public Client getClient() {        return client;    }    public void setClient(Client client) {        this.client = client;    }}