package com.kamiltest.demo.doa.viewModels;

public class viewModelCarClient {
    private Long idCar;
    private Long idClient;

    public viewModelCarClient() {
    }

    public viewModelCarClient(Long idCar, Long idClient) {
        this.idCar = idCar;
        this.idClient = idClient;
    }

    public Long getIdCar() {
        return idCar;
    }

    public void setIdCar(Long idCar) {
        this.idCar = idCar;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    @Override
    public String toString() {
        return "viewModelCarClient{" +
                "idCar=" + idCar +
                ", idClient=" + idClient +
                '}';
    }
}
