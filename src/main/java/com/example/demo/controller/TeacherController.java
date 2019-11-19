package com.example.demo.controller;


import com.example.demo.domain.HomeWork;
import com.example.demo.domain.LessonTheme;
import com.example.demo.domain.Test;
import com.example.demo.security.AccountUserDetails;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/mainTeacher")
public class TeacherController {

    @Autowired
    private TeacherSubjectClassService teacherSubjectClassService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private MarksService marksService;
    @Autowired
    private FrequencyService frequencyService;

    @Autowired
    private TimeTableService timeTableService;

    @Autowired
    private HomeWorkService homeWorkService;

    @Autowired
    private LessonThemeService lessonThemeService;

    @Autowired
    private TestService testService;

    @GetMapping
    public String teacherMainPage(@AuthenticationPrincipal AccountUserDetails account, Map<String,Object> teacherSubjectClass){
        teacherSubjectClass.put("idAccount",account.getId());
        teacherSubjectClass.put("nameTeacher",teacherService.findTeacherByIdAccount(account.getId()).getName());
//        teacherSubjectClass.put("nameClass",teacherSubjectClassService.findClassesByIdTeacher(teacherService.findTeacherByIdAccount(account.getId()).getIdTeacher()));//working
//        teacherSubjectClass.put("subject",teacherSubjectClassService.findSubjectsByIdTeacher(teacherService.findTeacherByIdAccount(account.getId()).getIdTeacher()));
        teacherSubjectClass.put("classSubject",teacherSubjectClassService.findTSCByIdTeacher(teacherService.findTeacherByIdAccount(account.getId()).getIdTeacher()));
        return "teacherMainPage";
    }

    @GetMapping(value = "/teacherSelectTSC")
    public String showSelectTSC (@RequestParam(value = "item",required = true) String item,
                                    @AuthenticationPrincipal AccountUserDetails account,
                                    Map<String,Object> map){
        map.put("classSubject",teacherSubjectClassService.findTSCByIdTeacher(teacherService.findTeacherByIdAccount(account.getId()).getIdTeacher()));
        map.put("showItem",item);
        return "teacherSelectTSC";
    }


    @GetMapping(value = "/showLesson")
    public String showClassSubject (@RequestParam(value = "idTSC",required = false) Long idTSC,
                                    @RequestParam(value = "date",required = false) Long dateSeconds,
                                    @AuthenticationPrincipal AccountUserDetails account,
                                    Map<String,Object> map){
        if (idTSC==null)
            return "redirect:/mainTeacher/teacherSelectTSC?item=showLesson";


        map.put("idTSC",idTSC);

        Date date=null;
        if (dateSeconds==null) {
           for (Date d:timeTableService.findAllDatesForLesson(idTSC)){
               if (d.before(Calendar.getInstance().getTime())||d.equals(Calendar.getInstance().getTime()))
                   date =new Date(d.getYear(),d.getMonth(),d.getDate());
           }
        }
        else {
            Date date1=new Date(dateSeconds);
            for (Date d:timeTableService.findAllDatesForLesson(idTSC)){
                if (d.before(date1)||d.equals(date1))
                    date =new Date(d.getYear(),d.getMonth(),d.getDate());
            }
        }
        map.put("listStudents",studentService.findStudentsByIdClass(teacherSubjectClassService.findTSCByIdTSC(idTSC).getaClass().getIdclass()));
        map.put("markList2",marksService.findMarksByIdStudentAndIdSubject(studentService.findStudentsByIdClass(teacherSubjectClassService.findTSCByIdTSC(idTSC).getaClass().getIdclass()),
                teacherSubjectClassService.findTSCByIdTSC(idTSC).getSubject().getIdsubject()));
        map.put("marksDate",marksService.findMarksByIdStudentAndIdSubjectAndDate(studentService.findStudentsByIdClass(teacherSubjectClassService.findTSCByIdTSC(idTSC).getaClass().getIdclass()),
                teacherSubjectClassService.findTSCByIdTSC(idTSC).getSubject().getIdsubject(),date));
        map.put("freqDate",frequencyService.findFrequencyByIdStudentAndIdSubjectAndDate(studentService.findStudentsByIdClass(teacherSubjectClassService.findTSCByIdTSC(idTSC).getaClass().getIdclass()),
                teacherSubjectClassService.findTSCByIdTSC(idTSC).getSubject().getIdsubject(),date));
        map.put("datesLessons",timeTableService.findAllDatesForLesson(idTSC));
        map.put("dateChosen",date);
        map.put("homeWork",homeWorkService.findHomeWorkByIdTscAndDateAdded(idTSC,date));
        map.put("lessonTheme",lessonThemeService.findLessonThemeByIdTscAndDate(idTSC,date));
        return "lessonProperty";
    }


    @GetMapping(value = "/showTest")
    public String showTest (@RequestParam(value = "idTSC",required = false) Long idTSC,
                                    @AuthenticationPrincipal AccountUserDetails account,
                                    Map<String,Object> map) {
        if (idTSC == null)
            return "redirect:/mainTeacher/teacherSelectTSC?item=showTest";
        map.put("idTSC",idTSC);
        map.put("tests",testService.findTestByIdTSC(idTSC));
        map.put("datesLessons",timeTableService.findAllDatesForLesson(idTSC));
        return "teacherShowTest";
    }

    @GetMapping(value = "/showMarks")
    public String showMarks (@RequestParam(value = "idTSC",required = false) Long idTSC,
                            @AuthenticationPrincipal AccountUserDetails account,
                            Map<String,Object> map) {
        if (idTSC == null)
            return "redirect:/mainTeacher/teacherSelectTSC?item=showMarks";
        map.put("idTSC",idTSC);
        map.put("tsc",teacherSubjectClassService.findTSCByIdTSC(idTSC));
        map.put("listStudents",studentService.findStudentsByIdClass(teacherSubjectClassService.findTSCByIdTSC(idTSC).getaClass().getIdclass()));
        map.put("markList",marksService.findMarksByIdStudentAndIdSubject(studentService.findStudentsByIdClass(teacherSubjectClassService.findTSCByIdTSC(idTSC).getaClass().getIdclass()),
                teacherSubjectClassService.findTSCByIdTSC(idTSC).getSubject().getIdsubject()));
        return "teacherShowMarks";
    }
    @GetMapping(value = "/showFrequency")
    public String showFrequency (@RequestParam(value = "idTSC",required = false) Long idTSC,
                             @AuthenticationPrincipal AccountUserDetails account,
                             Map<String,Object> map) {
        if (idTSC == null)
            return "redirect:/mainTeacher/teacherSelectTSC?item=showFrequency";
        map.put("idTSC",idTSC);
        map.put("tsc",teacherSubjectClassService.findTSCByIdTSC(idTSC));
        map.put("listStudents",studentService.findStudentsByIdClass(teacherSubjectClassService.findTSCByIdTSC(idTSC).getaClass().getIdclass()));
        map.put("freqList",frequencyService.findFrequencyByIdStudentAndIdSubject(studentService.findStudentsByIdClass(teacherSubjectClassService.findTSCByIdTSC(idTSC).getaClass().getIdclass()),
                teacherSubjectClassService.findTSCByIdTSC(idTSC).getSubject().getIdsubject()));
        map.put("freqPercent",frequencyService.findProcentFrequencyForTsc(timeTableService.findAllDatesForLessonBeforeToday(idTSC),frequencyService.findFrequencyByIdStudentAndIdSubject(studentService.findStudentsByIdClass(teacherSubjectClassService.findTSCByIdTSC(idTSC).getaClass().getIdclass()),
                teacherSubjectClassService.findTSCByIdTSC(idTSC).getSubject().getIdsubject())));
        return "teacherShowFrequency";
    }
    @GetMapping(value = "/showPlan")
    public String showPlan (@RequestParam(value = "date",required = false) Long dateSeconds,
                            @AuthenticationPrincipal AccountUserDetails account,
                                 Map<String,Object> map) {
        Date date=null;
        if (dateSeconds!=null)
            date=new Date(dateSeconds);
        else
            date=new Date(Calendar.getInstance().getTime().getTime());

        map.put("prevWeek",new Date(date.getTime()-(7*86400000L)));
        map.put("nextWeek",new Date(date.getTime()+(7*86400000L)));
        map.put("dates",timeTableService.findAllDatesInWeek(date));
        map.put("datesString",timeTableService.findAll());
        map.put("lessonTime",timeTableService.findAllLessonTime());
        map.put("timeTable",timeTableService.findTimeTableByIdTeacher(teacherService.findTeacherByIdAccount(account.getId()).getIdTeacher()));
        return "teacherPlan";
    }



        @PostMapping("/saveProperties")
    public String addMarks(@RequestParam("idTSC") Long idTSC,
                           @RequestParam(value = "date",required = true) Long dateSeconds,
                           @RequestParam("studentProp") List<String> studentProp){
ArrayList<String> studentMarks=new ArrayList<>();
ArrayList<String> studentFreq=new ArrayList<>();
        for (String s:studentProp) {
            if (s.equals("n"))
                studentFreq.add(s);
            else studentFreq.add("");

            if (s.matches("\\d+")&&s.length()==1)
                studentMarks.add(s);
            else studentMarks.add("");
        }

Date date=new Date(dateSeconds);
frequencyService.addFrequency(studentService.findStudentsByIdClass(teacherSubjectClassService.findTSCByIdTSC(idTSC).getaClass().getIdclass()),
        teacherSubjectClassService.findTSCByIdTSC(idTSC).getSubject(),
        date,studentFreq);
        marksService.addMarks(studentService.findStudentsByIdClass(teacherSubjectClassService.findTSCByIdTSC(idTSC).getaClass().getIdclass()),
                teacherSubjectClassService.findTSCByIdTSC(idTSC).getSubject(),
                date,studentMarks);
        return "redirect:/mainTeacher/showLesson?idTSC="+idTSC+"&date="+dateSeconds;
    }

    @GetMapping(value = "/showAll")
    public String showAllStudentsAndMarks (@RequestParam("idTSC") Long idTSC,
                                    Map<String,Object> map){

        map.put("idTSC",idTSC);
        map.put("listStudents",studentService.findStudentsByIdClass(teacherSubjectClassService.findTSCByIdTSC(idTSC).getaClass().getIdclass()));
        map.put("markList",marksService.findMarksByIdStudentAndIdSubject(studentService.findStudentsByIdClass(teacherSubjectClassService.findTSCByIdTSC(idTSC).getaClass().getIdclass()),
                teacherSubjectClassService.findTSCByIdTSC(idTSC).getSubject().getIdsubject()));
        map.put("datesLessons",timeTableService.findAllDatesForLesson(idTSC));
        map.put("freqList",frequencyService.findFrequencyByIdStudentAndIdSubject(studentService.findStudentsByIdClass(teacherSubjectClassService.findTSCByIdTSC(idTSC).getaClass().getIdclass()),
                teacherSubjectClassService.findTSCByIdTSC(idTSC).getSubject().getIdsubject()));
        return "listStudentsMarks";
    }

    @PostMapping("/addHomeWork")
    public String addHomeWork(@RequestParam("idTSC") Long idTSC,
                           @RequestParam(value = "date",required = true) Long dateSeconds,
                           @RequestParam("homeWork") String hw){
        HomeWork homeWork = new HomeWork();
        homeWork.setDateAdded(new Date(dateSeconds+86400000L));
        homeWork.setDateDue(new Date(timeTableService.findNextDateForLessonByIdTSCAndDate(idTSC,new Date(dateSeconds)).getTime()+86400000L));
        homeWork.setHomeWork(hw);
        homeWork.setTsc(teacherSubjectClassService.findTSCByIdTSC(idTSC));
        homeWorkService.addHomework(homeWork);
        return "redirect:/mainTeacher/showLesson?idTSC="+idTSC+"&date="+dateSeconds;
    }

    @PostMapping("/addLessonTheme")
    public String addLessonTheme(@RequestParam("idTSC") Long idTSC,
                           @RequestParam(value = "date",required = true) Long dateSeconds,
                           @RequestParam("lessonTheme") String lt){
        LessonTheme lessonTheme = new LessonTheme();
        lessonTheme.setTheme(lt);
        lessonTheme.setDate(new Date(dateSeconds+86400000L));
        lessonTheme.setTsc(teacherSubjectClassService.findTSCByIdTSC(idTSC));
        lessonThemeService.addLessonTheme(lessonTheme);
        return "redirect:/mainTeacher/showLesson?idTSC="+idTSC+"&date="+dateSeconds;
    }
    @PostMapping("/addTest")
    public String addTest(@RequestParam("idTSC") Long idTSC,
                                 @RequestParam(value = "date",required = true) Long dateSeconds,
                                 @RequestParam("test") String test){
        Test testOb= new Test();
        testOb.setTest(test);
        testOb.setDate(new Date(dateSeconds+86400000L));
        testOb.setTsc(teacherSubjectClassService.findTSCByIdTSC(idTSC));
        testService.addTest(testOb);
        return "redirect:/mainTeacher/showTest?idTSC="+idTSC;
    }
    @PostMapping("/deleteTest")
    public String deleteTest(@RequestParam("idTSC") Long idTSC,
                          @RequestParam(value = "idTest",required = true) Integer idTest){

        testService.deleteTest(testService.findTestByIdTSC(idTSC).get(idTest));
        return "redirect:/mainTeacher/showTest?idTSC="+idTSC;
    }


}
