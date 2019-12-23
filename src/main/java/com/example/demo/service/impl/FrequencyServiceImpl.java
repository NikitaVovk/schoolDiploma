package com.example.demo.service.impl;

import com.example.demo.dao.FrequencyDao;
import com.example.demo.domain.Frequency;
import com.example.demo.domain.Marks;
import com.example.demo.domain.Student;
import com.example.demo.domain.Subject;
import com.example.demo.service.FrequencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service("frequencyService")
@Transactional
public class FrequencyServiceImpl implements FrequencyService {

    @Autowired
    private FrequencyDao frequencyDao;

    @Override
    public ArrayList<List<Frequency>> findFrequencyByIdStudentAndIdSubject(List<Student> students, Long idSubject) {
        ArrayList<List<Frequency>> frequencyList = new ArrayList<>();

        for (Student student:students) {
            List<Frequency> freq = frequencyDao.findFrequencyByIdStudentAndIdSubject(student.getIdstudent(),idSubject);

            frequencyList.add(freq);

        }

        return frequencyList;
    }

    @Override
    public ArrayList<List<Frequency>> findFrequencyByIdStudentAndIdSubject(Student student, List<Subject> subjects) {
        ArrayList<List<Frequency>> freqList = new ArrayList<>();

        for (Subject subject:subjects) {
            List<Frequency> freq = frequencyDao.findFrequencyByIdStudentAndIdSubject(student.getIdstudent(),subject.getIdsubject());
            freqList.add(freq);

        }

        return freqList;
    }

    @Override
    public ArrayList<Float> findProcentFrequency(ArrayList<ArrayList<Date>> dates, ArrayList<List<Frequency>> freqs) {
        ArrayList<Float> percent = new ArrayList<>();
        System.out.println("HIIIIIIIIIIII IM COUNTING PERCENT FOR U MA FRIEND: "+dates.size()+"AUUUUUUUU: "+freqs.size());
        System.out.println(dates.get(0).size()+"    "+freqs.get(0).size());
        for (int i = 0; i<dates.size();i++){
            Float f;
            f=(float)(freqs.get(i).size()*100)/dates.get(i).size();
            f=100-f;
            percent.add(f);
        }
        return percent;
    }

    @Override
    public ArrayList<Float> findProcentFrequencyForTsc(ArrayList<Date> dates, ArrayList<List<Frequency>> freqs) {
        ArrayList<Float> percent = new ArrayList<>();
        System.out.println("HIIIIIIIIIIII IM COUNTING PERCENT FOR U MA FRIEND: "+dates.size()+"AUUUUUUUU: "+freqs.size());
        //System.out.println(dates.get(0).size()+"    "+freqs.get(0).size());
        for (Date d:dates) {
            System.out.println(d);
        }
        for (int i = 0; i<freqs.size();i++){
            Float f;
            f=(float)(freqs.get(i).size()*100)/dates.size();
            f=100-f;
            percent.add(f);
        }
        return percent;
    }

    @Override
    public ArrayList<List<Frequency>> findFrequencyByIdStudentAndDates(Long idStudent, List<Date> dates) {
        ArrayList<List<Frequency>> freqArrayList=new ArrayList<>();
        for (Date d:dates) {
            freqArrayList.add(frequencyDao.findFrequencyByIdStudentAndDate(idStudent,d));
        }

        return freqArrayList;
    }

    @Override
    public List<Frequency> findFrequencyByIdStudentAndIdSubject(Long idStudent, Long idSubject) {
        return null;
    }

    @Override
    public ArrayList<Frequency> findFrequencyByIdStudentAndIdSubjectAndDate(List<Student> students, Long idSubject, Date date) {
        ArrayList<Frequency> frequencyArrayList=new ArrayList<>();
//        Date dateTest = new Date();
//        dateTest.setDate(1);
//        dateTest.setMonth(1);
//        dateTest.setYear(2020);
        for (Student student:students) {
            frequencyArrayList.add(frequencyDao.findFrequencyByIdStudentAndIdSubjectAndDate(student.getIdstudent(),idSubject,date));

        }
        for (Frequency m: frequencyArrayList) {

            System.out.println(m);
        }
        return frequencyArrayList;
    }

    @Override
    public Frequency findFrequencyByIdMark(Long id) {
        return null;
    }

    @Override
    public ArrayList<Frequency> addFrequency(List<Student> students, Subject subject, Date date, List<String> freq) {
        ArrayList<Frequency>marksArrayList = null;
        System.out.println("IM ADDING frequency WITH DATE:"+date+"\n\n\n\n");
        for (int i = 0; i<freq.size();i++){
            if (freq.get(i).isEmpty()){
                if (frequencyDao.findFrequencyByIdStudentAndIdSubjectAndDate(students.get(i).getIdstudent(),subject.getIdsubject(),date)!=null)
                    frequencyDao.deleteFrequency(frequencyDao.findFrequencyByIdStudentAndIdSubjectAndDate(students.get(i).getIdstudent(),subject.getIdsubject(),date));
            }
            else{
                if (frequencyDao.findFrequencyByIdStudentAndIdSubjectAndDate(students.get(i).getIdstudent(),subject.getIdsubject(),date)!=null)
                    frequencyDao.deleteFrequency(frequencyDao.findFrequencyByIdStudentAndIdSubjectAndDate(students.get(i).getIdstudent(),subject.getIdsubject(),date));
                Frequency frequency = new Frequency();
                frequency.setDate(new Date(date.getYear(),date.getMonth(),date.getDate()+1));
                frequency.setStudent(students.get(i));
                frequency.setFrequency(freq.get(i));
                frequency.setSubject(subject);
                // marksArrayList.add(marks);
                frequencyDao.addFrequency(frequency);

            }
        }

        return marksArrayList;
    }
}
