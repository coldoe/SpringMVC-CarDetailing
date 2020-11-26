package com.kamiltest.demo.doa.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @PrimaryKeyJoinColumn
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @NotBlank(message = "You need to fill all fields, fields wont pass without values")
    @NotNull(message = "You need to fill all fields, fields wont pass without values")
    @NotEmpty(message = "You need to fill all fields, fields wont pass without values")
    @Size(min = 8,max = 100,message = "Required length is between 8 and 100 characters")
    private String Username;

    @NotBlank(message = "You need to fill all fields, fields wont pass without values")
    @NotNull(message = "You need to fill all fields, fields wont pass without values")
    @NotEmpty(message = "You need to fill all fields, fields wont pass without values")
    @Size(min = 8,max = 1200,message = "Required length is between 8 and 100 characters")
    private String Password;

    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
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
