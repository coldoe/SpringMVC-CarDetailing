package com.kamiltest.demo.doa.model;import com.fasterxml.jackson.annotation.JsonManagedReference;import javax.persistence.*;@Entitypublic class Client {    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)//    @PrimaryKeyJoinColumn    private Long Id;    private String name;    private String surname;    private String contactNumber;    @OneToOne(cascade = CascadeType.ALL)    @JoinColumn(name = "car_id",referencedColumnName = "Id")    private Car car;//    @OneToOne(cascade = CascadeType.ALL)//    private Order order;    public Client() {    }    public Client(Long id, String name, String surname, String contactNumber, Car car, Order order) {        Id = id;        this.name = name;        this.surname = surname;        this.contactNumber = contactNumber;        this.car = car;//        this.order = order;    }    @Override    public String toString() {        return "Client{" +                "Id=" + Id +                ", name='" + name + '\'' +                ", surname='" + surname + '\'' +                ", contactNumber='" + contactNumber + '\'' +                ", car=" + car.getId() +                '}';//        return null;    }    //to prevent recursion    @JsonManagedReference//    @JsonBackReference    public Car getCar() {        return car;    }    public void setCar(Car car) {        this.car = car;    }    public Long getId() {        return Id;    }    public void setId(Long id) {        Id = id;    }    public String getName() {        return name;    }    public void setName(String name) {        this.name = name;    }    public String getSurname() {        return surname;    }    public void setSurname(String surname) {        this.surname = surname;    }    public String getContactNumber() {        return contactNumber;    }    public void setContactNumber(String contactNumber) {        this.contactNumber = contactNumber;    }//    @JsonBackReference//    public Order getOrder() {//        return order;//    }////    public void setOrder(Order order) {//        this.order = order;//    }}