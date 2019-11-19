package com.example.demo.domain;


import javax.persistence.*;

@Entity
@Table(name = "TimeTable")
public class TimeTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long idTimeTable;

    @ManyToOne
    private DaysOfWeek daysOfWeek;
    @ManyToOne
    private LessonTime lessonTime;

    @ManyToOne
    private TeacherSubjectClass teacherSubjectClass;

    public TimeTable( ) {

    }

    public LessonTime getLessonTime() {
        return lessonTime;
    }

    public void setLessonTime(LessonTime lessonTime) {
        this.lessonTime = lessonTime;
    }

    public Long getIdTimeTable() {
        return idTimeTable;
    }

    public void setIdTimeTable(Long idTimeTable) {
        this.idTimeTable = idTimeTable;
    }

    public DaysOfWeek getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(DaysOfWeek daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    public TeacherSubjectClass getTeacherSubjectClass() {
        return teacherSubjectClass;
    }

    public void setTeacherSubjectClass(TeacherSubjectClass teacherSubjectClass) {
        this.teacherSubjectClass = teacherSubjectClass;
    }
}