package com.kamiltest.demo.doa.viewModels;

import com.kamiltest.demo.doa.model.User;

import javax.validation.Valid;
import javax.validation.constraints.*;

public class addNewUser {
    @NotBlank(message = "You need to fill all fields, fields wont pass without values")
    @NotNull(message = "You need to fill all fields, fields wont pass without values")
    @NotEmpty(message = "You need to fill all fields, fields wont pass without values")
    private Long idRole;

    @Valid
    private User user;

    public addNewUser() {
    }

    public addNewUser(Long idRole, User user) {
        this.idRole = idRole;
        this.user = user;
    }

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "addNewUser{" +
                "idRole=" + idRole +
                ", user=" + user +
                '}';
    }
}
