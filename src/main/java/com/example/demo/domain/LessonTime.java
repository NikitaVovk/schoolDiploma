package com.example.demo.domain;


import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "LessonTime")
public class LessonTime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idLessonTime")
    private Long id;

    private Integer count;

    private Time timeStart;

    private Time timeEnd;

    public LessonTime() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Time getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Time timeStart) {
        this.timeStart = timeStart;
    }

    public Time getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Time timeEnd) {
        this.timeEnd = timeEnd;
    }
}
