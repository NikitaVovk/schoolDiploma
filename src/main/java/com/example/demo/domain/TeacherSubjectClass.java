package com.example.demo.domain;


import javax.persistence.*;

@Entity
@Table(name = "teacher_subject_class")
public class TeacherSubjectClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Teacher teacher;
    @ManyToOne(fetch = FetchType.EAGER)
    private Subject subject;
    @ManyToOne(fetch = FetchType.EAGER)
    private Class aClass;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public TeacherSubjectClass(){}

    public TeacherSubjectClass(Teacher teacher) {
        this.teacher = teacher;
    }

    public TeacherSubjectClass(Teacher teacher, Subject subject, Class aClass) {
        this.teacher = teacher;
        this.subject = subject;
        this.aClass = aClass;
    }

    public TeacherSubjectClass(Class aClass) {
        this.aClass = aClass;
    }

    public TeacherSubjectClass(Subject subject) {
        this.subject = subject;
    }
}
