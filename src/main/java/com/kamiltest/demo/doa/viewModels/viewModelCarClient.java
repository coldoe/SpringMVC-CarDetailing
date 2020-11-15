package com.kamiltest.demo.doa.viewModels;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class viewModelCarClient {
    @Min(value = 1,message = "Required")
    @NotBlank(message = "You need to fill all fields, fields wont pass without values")
    @NotNull(message = "You need to fill all fields, fields wont pass without values")
    @NotEmpty(message = "You need to fill all fields, fields wont pass without values")
    private Long idCar;

    @Min(value = 1,message = "Required")
    @NotBlank(message = "You need to fill all fields, fields wont pass without values")
    @NotNull(message = "You need to fill all fields, fields wont pass without values")
    @NotEmpty(message = "You need to fill all fields, fields wont pass without values")
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
