package com.example.demo.domain;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "marks")
public class Marks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmarks")
    private Long idmarks;

    @ManyToOne
    private Student student;
    @ManyToOne
    private Subject subject;

    @Column(name = "mark")
    private Long mark;

    @Column(name = "date")
    private java.sql.Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Marks() {

    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Long getIdmarks() {
        return idmarks;
    }

    public void setIdmarks(Long idmarks) {
        this.idmarks = idmarks;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }



    public Long getMark() {
        return mark;
    }

    public void setMark(Long mark) {
        this.mark = mark;
    }
}
