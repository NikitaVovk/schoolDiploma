package com.example.demo.controller;


import com.example.demo.domain.*;
import com.example.demo.security.AccountUserDetails;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/mainStudent")
@SessionAttributes(value = "studentJSP")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private MarksService marksService;
    @Autowired
    private TimeTableService tableService;
    @Autowired
    private TeacherSubjectClassService tsc;
    @Autowired
    private FrequencyService frequencyService;
    @Autowired
    private HomeWorkService homeWorkService;
    @Autowired
    private TestService testService;
    @Autowired
    private AccountService accountService;

    @GetMapping
    public ModelAndView studentMainPage(@AuthenticationPrincipal AccountUserDetails account, Map<String,Object> map){
    map.put("student",studentService.findStudentByIdAccount(account.getId()));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("student/studentPage");
        modelAndView.addObject("studentJSP",studentService.findStudentByIdAccount(account.getId()));

        return modelAndView;
    }

    @GetMapping("/")
    public String studentDayBook(){

        return "student/studentPage";
    }

    @GetMapping("/marks")
    public String studentMarks(@AuthenticationPrincipal AccountUserDetails account, Map<String,Object> map){
        map.put("subjects",subjectService.findSubjectsByIdClass(studentService.findStudentByIdAccount(account.getId()).getaClass().getIdclass()));
        map.put("marksSubject",marksService.findMarksByIdStudentAndIdSubject(studentService.findStudentByIdAccount(account.getId()),
                subjectService.findSubjectsByIdClass(studentService.findStudentByIdAccount(account.getId()).getaClass().getIdclass())));
        return "student/studentMarks";
    }

    @GetMapping("/frequency")
    public String studentFrequency(@AuthenticationPrincipal AccountUserDetails account, Map<String,Object> map){
        map.put("subjects",subjectService.findSubjectsByIdClass(studentService.findStudentByIdAccount(account.getId()).getaClass().getIdclass()));
        ArrayList<List<Frequency>> freqLists = new ArrayList<>();
        freqLists=frequencyService.findFrequencyByIdStudentAndIdSubject(studentService.findStudentByIdAccount(account.getId()),
                subjectService.findSubjectsByIdClass(studentService.findStudentByIdAccount(account.getId()).getaClass().getIdclass()));
        map.put("freqSubject",freqLists);
        ArrayList<ArrayList<Date>>dateLists= new ArrayList<>();
        dateLists= tableService.findAllDatesForLessonBeforeToday
                (tsc.findTSCByIdClassAndIdSubject
                        (studentService.findStudentByIdAccount(account.getId()).getaClass().getIdclass(),
                                subjectService.findSubjectsByIdClass
                                        (studentService.findStudentByIdAccount(account.getId()).getaClass().getIdclass())));
       map.put("percents", frequencyService.findProcentFrequency(dateLists,freqLists));

        return "student/studentFrequency";
    }

    @GetMapping("/homeWork")
    public String studentHomeWork(@RequestParam(value = "date",required = false) Long dateSeconds,
                                 @AuthenticationPrincipal AccountUserDetails account,
                                 Map<String,Object> map){
        Date date=null;
        if (dateSeconds!=null)
            date=new Date(dateSeconds);
        else
            date=new Date(Calendar.getInstance().getTime().getTime());

        map.put("prevWeek",new Date(date.getTime()-(7*86400000L)));
        map.put("nextWeek",new Date(date.getTime()+(7*86400000L)));
        map.put("dates",tableService.findAllDatesInWeek(date));
        map.put("datesString",tableService.findAll());
        map.put("homeWork",homeWorkService.findHomeWorkByIdTscAndDatesDue(tsc.findTSCByIdClassAndIdSubject
                (studentService.findStudentByIdAccount(account.getId()).getaClass().getIdclass(),
                        subjectService.findSubjectsByIdClass
                                (studentService.findStudentByIdAccount(account.getId()).getaClass().getIdclass())),tableService.findAllDatesInWeek(date)));
        return "student/studentHomeWork";
    }

    @GetMapping("/dayBook")
    public String studentDayBook(@RequestParam(value = "date",required = false) Long dateSeconds,
                                 @AuthenticationPrincipal AccountUserDetails account,
                                 Map<String,Object> map){
        Date date=null;
        if (dateSeconds!=null)
            date=new Date(dateSeconds);
        else
            date=new Date(Calendar.getInstance().getTime().getTime());

        map.put("prevWeek",new Date(date.getTime()-(7*86400000L)));
        map.put("nextWeek",new Date(date.getTime()+(7*86400000L)));
        map.put("dates",tableService.findAllDatesInWeek(date));
        map.put("datesString",tableService.findAll());
        map.put("lessonTime",tableService.findAllLessonTime());
        map.put("timeTable",tableService.findTimeTableByIdClass(studentService.findStudentByIdAccount(account.getId()).getaClass().getIdclass()));
        map.put("marks",marksService.findMarksByIdStudentAndDates(studentService.findStudentByIdAccount(account.getId()).getIdstudent(),
                tableService.findAllDatesInWeek(date)));
        map.put("frequency",frequencyService.findFrequencyByIdStudentAndDates(studentService.findStudentByIdAccount(account.getId()).getIdstudent(),
                tableService.findAllDatesInWeek(date)));


        System.out.println( tableService.findAllLessonTime().get(0).getTimeStart().toLocalTime());
        return "student/studentDayBook";
    }

    @GetMapping("/test")
    public String studentTest(@RequestParam(value = "date",required = false) Long dateSeconds,
                                 @AuthenticationPrincipal AccountUserDetails account,
                                 Map<String,Object> map){
        Date date=null;
        if (dateSeconds!=null)
            date=new Date(dateSeconds);
        else
            date=new Date(Calendar.getInstance().getTime().getTime());

        ArrayList<ArrayList<Date>>dates=tableService.findAllDatesForFourWeeks(date);
        map.put("prevWeek",new Date(date.getTime()-(7*86400000L)));
        map.put("nextWeek",new Date(date.getTime()+(7*86400000L)));
        map.put("dates",dates);
        map.put("datesString",tableService.findAll());
        map.put("tests",testService.findTestByIdClassAndBetweenDates(studentService.findStudentByIdAccount(account.getId()).getaClass().getIdclass(),
                dates.get(0).get(0),
                dates.get(dates.size()-1).get(dates.get(dates.size()-1).size()-1)));
        return "student/studentTest";
    }


    @GetMapping("/schoolAndTeachers")
    public String schoolAndTeachers(@AuthenticationPrincipal AccountUserDetails account, Map<String,Object> map){
        map.put("tsc",tsc.findTSCByIdClass(studentService.findStudentByIdAccount(account.getId()).getaClass().getIdclass()));
        return "student/studentSchool";
    }
    @GetMapping("/data")
    public String studentData(@AuthenticationPrincipal AccountUserDetails account, Map<String,Object> map,
                              @RequestParam(value = "edit",required = false,defaultValue = "false") Boolean edit){
        map.put("student",studentService.findStudentByIdAccount(account.getId()));
        map.put("edit",edit);
        return "student/studentData";
    }

    @RequestMapping(value = "/editData", method = RequestMethod.POST)
    public String editData(@AuthenticationPrincipal AccountUserDetails account,
                           @RequestParam(value="address")String address,
                           @RequestParam(value="email")String email,
                           @RequestParam(value="phone")String phone) {
        Student student = studentService.findStudentByIdAccount(account.getId());
        student.setAddress(address);
        student.setPhone(phone);
        student.setEmail(email);
        studentService.editStudent(student);
        return "redirect:/mainStudent/data";
    }
    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public String changePassword(@AuthenticationPrincipal AccountUserDetails account,
                           @RequestParam(value="currentPassword")String currentPassword,
                           @RequestParam(value="newPassword")String newPassword,
                           @RequestParam(value="repeatNewPassword")String repeatNewPassword){
            Account accountStudent = studentService.findStudentByIdAccount(account.getId()).getAccount();
            if (currentPassword.equals(accountStudent.getPassword())&&newPassword.equals(repeatNewPassword)){
                accountStudent.setPassword(newPassword);
                accountService.editAccount(accountStudent);
            }

        return "redirect:/mainStudent/data";
    }

}



