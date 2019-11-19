package com.example.demo.domain;

import javax.persistence.*;

@Entity
@Table(name = "class")
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idclass")
    private Long idclass;

    @Column(name = "name")
    private String name;

    public Long getIdclass() {
        return idclass;
    }

    public void setIdclass(Long idclass) {
        this.idclass = idclass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class() {
    }
}
