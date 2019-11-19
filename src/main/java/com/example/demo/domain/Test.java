package com.example.demo.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Test")
public class Test {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "idTest")
        private Long id;

        private String test;
        @ManyToOne
        private TeacherSubjectClass tsc;

        private Date date;

    public Test() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public TeacherSubjectClass getTsc() {
        return tsc;
    }

    public void setTsc(TeacherSubjectClass tsc) {
        this.tsc = tsc;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
