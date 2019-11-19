package com.example.demo.domain;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "HomeWork")
public class HomeWork {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idHomeWork")
    private Long id;

    private String homeWork;

    @ManyToOne
    private TeacherSubjectClass tsc;

    private Date dateAdded;

    private Date dateDue;

    public HomeWork() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHomeWork() {
        return homeWork;
    }

    public void setHomeWork(String homeWork) {
        this.homeWork = homeWork;
    }

    public TeacherSubjectClass getTsc() {
        return tsc;
    }

    public void setTsc(TeacherSubjectClass tsc) {
        this.tsc = tsc;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Date getDateDue() {
        return dateDue;
    }

    public void setDateDue(Date dateDue) {
        this.dateDue = dateDue;
    }
}
