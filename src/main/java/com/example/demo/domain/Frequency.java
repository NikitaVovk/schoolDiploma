package com.example.demo.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "frequency")
public class Frequency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idfrequency")
    private Long idfrequency;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Subject subject;

    @Column(name = "frequency")
    private String frequency;

    @Column(name = "date")
    private java.sql.Date date;

    public Frequency() {
    }

    public Long getIdfrequency() {
        return idfrequency;
    }

    public void setIdfrequency(Long idfrequency) {
        this.idfrequency = idfrequency;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

