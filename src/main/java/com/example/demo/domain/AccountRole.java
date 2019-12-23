package com.example.demo.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="ac_RoleS")
public class AccountRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idac_Roles")
    private Long idac_Roles;

    @Size(min=3, max=50)
    @NotNull
    @Column(name = "ROLE",  updatable = false, nullable = false, unique = true)
    private String role;

    public Long getId() {
        return idac_Roles;
    }

    public void setId(Long idac_Roles) {
        this.idac_Roles = idac_Roles;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public AccountRole() {

    }

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long idaccountRole;
//
//    @NotNull
//    @Column(name = "username", updatable = false, nullable = false, unique = true)
//    private String username;
//
//    @NotNull
//    @Column(name = "role", updatable = false, nullable = false, unique = true)
//    private String role;
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }
//
//    public Long getIdaccountRole() {
//        return idaccountRole;
//    }
//
//    public void setIdaccountRole(Long idaccountRole) {
//        this.idaccountRole = idaccountRole;
//    }
}
