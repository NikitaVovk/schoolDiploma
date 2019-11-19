package com.example.demo.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "LessonTheme")
public class LessonTheme {


        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "idHomeWork")
        private Long id;

        private String theme;

        @ManyToOne
        private TeacherSubjectClass tsc;

        private Date date;

    public LessonTheme() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
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
