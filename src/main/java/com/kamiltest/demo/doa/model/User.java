package com.kamiltest.demo.doa.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @PrimaryKeyJoinColumn
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    private String Username;

    private String Password;

    private boolean enabled;

    @ManyToMany()
    @JoinTable(
            name = "users_roles",
//            ,referencedColumnName = "idUser"
            joinColumns = @JoinColumn(name = "idUser",referencedColumnName = "idUser"),
            inverseJoinColumns = @JoinColumn(name = "idRole",referencedColumnName = "idRole")
    )
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
