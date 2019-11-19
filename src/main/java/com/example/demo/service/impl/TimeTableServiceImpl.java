package com.example.demo.service.impl;


import com.example.demo.dao.DaysOfWeekDao;
import com.example.demo.dao.LessonTimeDao;
import com.example.demo.dao.TimeTableDao;
import com.example.demo.domain.DaysOfWeek;
import com.example.demo.domain.LessonTime;
import com.example.demo.domain.TeacherSubjectClass;
import com.example.demo.domain.TimeTable;
import com.example.demo.service.TimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.sql.Date;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service("timeTableService")
@Transactional
public class TimeTableServiceImpl implements TimeTableService {
    @Autowired
    DaysOfWeekDao daysOfWeekDao;
    @Autowired
    LessonTimeDao lessonTimeDao;
    @Autowired
    TimeTableDao timeTableDao;
    @Override
    public ArrayList<Date> findAllDatesForLesson(Long idTSC) {
        List<DaysOfWeek> daysOfWeeks = timeTableDao.findDaysByIdTSC(idTSC);
        ArrayList<Date> dates=new ArrayList<>();
        Calendar calendarYear= Calendar.getInstance();

        for (int j=8;j<=16;j++) {
            int month=j;
            int year = calendarYear.getTime().getYear()+1900;
            YearMonth yearMonthObject;
            if (j>=12) {
                month = month - 12;
                year+=1;
            }
            yearMonthObject  = YearMonth.of(year, month+1);



            for (int i = 1; i <=yearMonthObject.lengthOfMonth(); i++) {
                Calendar c = Calendar.getInstance();
                c.set(year, month, i);
                // System.out.println(c.getTime());
                for (DaysOfWeek day:daysOfWeeks) {
                    if (c.get(Calendar.DAY_OF_WEEK) == day.getId()) {
                        dates.add(new Date(c.getTime().getYear(),c.getTime().getMonth(),c.getTime().getDate()));
                    }
                }

            }
        }
return dates;
    }

    @Override
    public ArrayList<Date> findAllDatesForLessonBeforeToday(Long idTSC) {
        List<DaysOfWeek> daysOfWeeks = timeTableDao.findDaysByIdTSC(idTSC);
        ArrayList<Date> dates=new ArrayList<>();
        Calendar calendar= Calendar.getInstance();
        java.util.Date date=new java.util.Date(119,8,1);//calendar.getTime();
        calendar.setTime(date);
        Calendar c = Calendar.getInstance();

        while (calendar.before(c) &&!(new Date(calendar.getTime().getTime()).toString().equals(new Date(c.getTime().getTime()).toString()))){
            calendar.add(Calendar.DATE, 1);
          //  System.out.println(new Date(calendar.getTime().getTime()).toString()+"ALOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO BLAT"+new Date(c.getTime().getTime()).toString()+"understand???"+new Date(calendar.getTime().getTime()).toString().equals(new Date(c.getTime().getTime()).toString()));
            for (DaysOfWeek day: daysOfWeeks){
            if (calendar.get(Calendar.DAY_OF_WEEK)==day.getId()){
                dates.add(new Date(calendar.getTime().getTime()));
            }
        }
        }
        return dates;
    }

    @Override
    public ArrayList<ArrayList<Date>> findAllDatesForLessonBeforeToday(ArrayList<TeacherSubjectClass> tsc) {
        ArrayList<ArrayList<Date>> dates = new ArrayList<ArrayList<Date>>();
        for (TeacherSubjectClass t :tsc){
            dates.add(this.findAllDatesForLessonBeforeToday(t.getId()));
        }
        return dates;
    }

    @Override
    public ArrayList<Date> findAllDatesInWeek(Date date) {
        Calendar calendar= Calendar.getInstance();
        ArrayList<Date> dates= new ArrayList<Date>();
        //Date date=new java.util.Date(119,9,2);//calendar.getTime();
        calendar.setTime(date);

        calendar.set(Calendar.DAY_OF_WEEK,2);
        while (calendar.get(Calendar.DAY_OF_WEEK)<7){
            dates.add(new Date(calendar.getTime().getTime()));
            calendar.add(Calendar.DATE,1);
        }
        return dates;
    }

    @Override
    public ArrayList< ArrayList<Date> > findAllDatesForFourWeeks(Date date) {
        ArrayList< ArrayList<Date> > dateArrayList = new ArrayList<>(4);
        Calendar calendar = Calendar.getInstance();
        for (int i = 0 ; i<4; i++){
            ArrayList<Date>dates= new ArrayList<>();
            for (Date d: this.findAllDatesInWeek(date)) {
                calendar.setTime(d);
                calendar.add(Calendar.DATE,7*i);
                dates.add(new Date(calendar.getTime().getTime()));
            }
            dateArrayList.add(dates);
        }
        return dateArrayList;
    }

    @Override
    public List<DaysOfWeek> findAll() {
        return daysOfWeekDao.findAll();
    }

    @Override
    public List<LessonTime> findAllLessonTime() {
        return timeTableDao.findAllLessonTime();
    }

    @Override
    public List<TimeTable> findTimeTableByIdClass(Long id) {
        return  timeTableDao.findTimeTableByIdClass(id);
    }

    @Override
    public List<TimeTable> findTimeTableByIdTeacher(Long id) {
        return timeTableDao.findTimeTableByIdTeacher(id);
    }

    @Override
    public void saveTimeTable(ArrayList<TeacherSubjectClass> tscList,Long idClass) {
        int licz=0;
        for (int i = 1;i<=10;i++){
            for (int j=1;j<=5;j++){
                TimeTable ttBuf =timeTableDao.findTimeTableByIdClassAndIdLessonTimeAndIdDayOfWeek(idClass,Long.valueOf(i) ,Long.valueOf(j+1));
               if (ttBuf!=null)
                   timeTableDao.deleteTimeTable(ttBuf);
                System.out.println(licz);
               if (tscList.get(licz)!=null){
                   TimeTable timeTable= new TimeTable();
                   System.out.println("NUUUUUUUUUZEEEEEEEEEEEE "+lessonTimeDao.findById(Long.valueOf(i)).getCount()+"  "+Long.valueOf(i));
                   System.out.println("NUUUUUUUUUZEEEEEEEEEEEE "+daysOfWeekDao.findById(Long.valueOf(j+1)).getName()+"  "+Long.valueOf(j+1));

                   timeTable.setLessonTime(lessonTimeDao.findById(Long.valueOf(i)));
                   timeTable.setDaysOfWeek(daysOfWeekDao.findById(Long.valueOf(j+1)));

                   timeTable.setTeacherSubjectClass(tscList.get(licz));
                   timeTableDao.addTimeTable(timeTable);
               }
                licz++;

//                if (tscList.get((i*j)-1)==null && ttBuf!=null)
//                    timeTableDao.deleteTimeTable(ttBuf);
//                else {
//                    timeTableDao.deleteTimeTable(timeTableDao.findTimeTableByIdClassAndIdLessonTimeAndIdDayOfWeek(idClass,Long.valueOf(i) ,Long.valueOf(j+1)));
//                    TimeTable timeTable= new TimeTable();
//                    timeTable.setDaysOfWeek(daysOfWeekDao.findById(Long.valueOf(j+1)));
//                    timeTable.setLessonTime(lessonTimeDao.findById(Long.valueOf(i)));
//                    timeTable.setTeacherSubjectClass(tscList.get((i*j)-1));
//                    timeTableDao.addTimeTable(timeTable);
//                }
            }
        }
    }

    @Override
    public Date findNextDateForLessonByIdTSCAndDate(Long id,Date today) {
        ArrayList<Date> dates = new ArrayList<>();
        dates= this.findAllDatesForLesson(id);
        for (Date d : dates){
            if (d.after(today))
                return d;
        }
        return null;
    }


}
