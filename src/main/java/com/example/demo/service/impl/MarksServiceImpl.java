package com.example.demo.service.impl;

import com.example.demo.dao.MarksDao;
import com.example.demo.dao.StudentDao;
import com.example.demo.domain.Marks;
import com.example.demo.domain.Student;
import com.example.demo.domain.Subject;
import com.example.demo.service.MarksService;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import java.util.List;

@Service("marksService")
@Transactional
public class MarksServiceImpl implements MarksService {
    @Autowired
    private MarksDao marksDao;



    @Override
    public ArrayList<List<Marks>> findMarksByIdStudentAndIdSubject(List<Student> students, Long idSubject) {
        ArrayList<List<Marks>> marksList = new ArrayList<>();

        for (Student student:students) {
            List<Marks> marks = marksDao.findMarksByIdStudentAndIdSubject(student.getIdstudent(),idSubject);
//            if (marks!=null)
//            marksList.add(marks);
//            else
//                marks.add(new Marks());
////            marksList.add(marks);
//            System.out.println(marks+"!!!MARKS SERVICE!!!");
//            for (Marks markses:marks) {
//                System.out.println(markses.getMark());
//            }
                marksList.add(marks);

        }

    return marksList;
    }

    @Override
    public ArrayList<List<Marks>> findMarksByIdStudentAndIdSubject(Student student, List<Subject> subjects) {
        ArrayList<List<Marks>> marksList = new ArrayList<>();

        for (Subject subject:subjects) {
            List<Marks> marks = marksDao.findMarksByIdStudentAndIdSubject(student.getIdstudent(),subject.getIdsubject());
            marksList.add(marks);

        }

        return marksList;
    }

    @Override
    public ArrayList<List<Marks>> findMarksByIdStudentAndDates(Long idStudent, List<Date> dates) {
        ArrayList<List<Marks>> marksArrayList=new ArrayList<>();
        for (Date d:dates) {
            marksArrayList.add(marksDao.findMarksByIdStudentAndDate(idStudent,d));
        }

        return marksArrayList;
    }


    @Override
    public List<Marks> findMarksByIdStudentAndIdSubject(Long idStudent, Long idSubject) {
        return marksDao.findMarksByIdStudentAndIdSubject(idStudent,idSubject);
    }

    @Override
    public ArrayList<Marks> findMarksByIdStudentAndIdSubjectAndDate(List<Student> students, Long idSubject, java.sql.Date date) {
        ArrayList<Marks> marksArrayList=new ArrayList<>();
//        Date dateTest = new Date();
//        dateTest.setDate(1);
//        dateTest.setMonth(1);
//        dateTest.setYear(2020);
        for (Student student:students) {
            marksArrayList.add(marksDao.findMarksByIdStudentAndIdSubjectAndDate(student.getIdstudent(),idSubject,date));

        }
        for (Marks m: marksArrayList) {

            System.out.println(m);
        }
        return marksArrayList;
    }

    @Override
    public Marks findMarkByIdMark(Long idMark) {
        return marksDao.findMarkByIdMark(idMark);
    }

    @Override
    public ArrayList<Marks> addMarks(List<Student> students, Subject subject, Date date, ArrayList<String> mark) {
        ArrayList<Marks>marksArrayList = null;
        System.out.println("IM ADDING MARKS WITH DATE:"+date+"\n\n\n\n");
        for (int i = 0; i<mark.size();i++){
            if (mark.get(i).isEmpty()){
                if (marksDao.findMarksByIdStudentAndIdSubjectAndDate(students.get(i).getIdstudent(),subject.getIdsubject(),date)!=null)
             marksDao.deleteMarks(marksDao.findMarksByIdStudentAndIdSubjectAndDate(students.get(i).getIdstudent(),subject.getIdsubject(),date));
            }
            else{
                if (marksDao.findMarksByIdStudentAndIdSubjectAndDate(students.get(i).getIdstudent(),subject.getIdsubject(),date)!=null)
                    marksDao.deleteMarks(marksDao.findMarksByIdStudentAndIdSubjectAndDate(students.get(i).getIdstudent(),subject.getIdsubject(),date));
                Marks marks = new Marks();
                marks.setDate(new Date(date.getYear(),date.getMonth(),date.getDate()+1));
                marks.setStudent(students.get(i));
                marks.setMark(Long.parseLong(mark.get(i)));
                marks.setSubject(subject);
               // marksArrayList.add(marks);
                marksDao.addMarks(marks);

            }
        }

        return marksArrayList;
    }
}

