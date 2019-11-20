package com.example.demo.controller;


import com.example.demo.domain.*;
import com.example.demo.domain.Class;
import com.example.demo.security.AccountUserDetails;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@Controller
@RequestMapping("/mainAdmin")
public class AdminController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ClassService classService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private MarksService marksService;
    @Autowired
    private TimeTableService timeTableService;
    @Autowired
    private TeacherSubjectClassService tsc;
    @Autowired
    private FrequencyService frequencyService;
    @Autowired
    private HomeWorkService homeWorkService;
    @Autowired
    private TestService testService;

    @GetMapping
    public String adminMainPage(@AuthenticationPrincipal AccountUserDetails account, Map<String,Object> map){

        return "admin/adminMainPage";
    }

    @GetMapping("/students")
    public String adminStudents(@RequestParam(value = "surname",required = false) String surname,
                                @RequestParam(value = "name",required = false) String name,
                                @RequestParam(value = "idClass",required = false) Long idClass,
            @AuthenticationPrincipal AccountUserDetails account, Map<String,Object> map){
        List<Student> students=null;
        if ((surname==null&& name==null)||(surname.isEmpty() && name.isEmpty()))
            students=studentService.findAll();
        else if (surname.isEmpty() && !name.isEmpty())
            students=studentService.findStudentByName(name);
        else if (!surname.isEmpty() && name.isEmpty())
            students=studentService.findStudentBySurName(surname);
        else
            students=studentService.findStudentBySurNameAndName(surname,name);
        if (idClass!=null)
            students=studentService.findStudentsByIdClass(idClass);
        map.put("classes",classService.findAll());
        map.put("studentList",students);
        return "admin/adminStudents";
    }
    @GetMapping("/studentEditor")
    public String studentEditor(@RequestParam(value = "idStudent",required = false) Long idStudent,
                                @AuthenticationPrincipal AccountUserDetails account, Map<String,Object> map){
        if (idStudent!=null)
        map.put("student",studentService.findStudentByIdStudent(idStudent));
        map.put("classes",classService.findAll());
        for (Class c:classService.findAll()
             ) {
            System.out.println(c.getName());
        }
        return "admin/adminStudentEditor";
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String addStudent(@RequestParam(value = "surname") String surname,
                             @RequestParam(value = "name") String name,
                                @RequestParam(value="aClass")Long idClass,
                             @RequestParam(value="dateOfBirth")String dateS){
        Student newStudent= new Student();
        java.util.Date date=null;

        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(dateS);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date dateSql = new Date(date.getTime()+86400000L);
        newStudent.setaClass(classService.findClassByIdClass(idClass));
        newStudent.setDateOfBirth(dateSql);
        newStudent.setName(name);
        newStudent.setSurname(surname);
        studentService.addStudent(newStudent);
        return "redirect:/mainAdmin/students";
    }
    @RequestMapping(value = "/editStudent", method = RequestMethod.POST)
    public String editStudent(@RequestParam(value = "idStudent") Long id,
                             @RequestParam(value = "surname") String surname,
                             @RequestParam(value = "name") String name,
                             @RequestParam(value="aClass")Long idClass,
                             @RequestParam(value="dateOfBirth")String dateS){
        Student student= studentService.findStudentByIdStudent(id);
        java.util.Date date=null;

        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(dateS);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date dateSql = new Date(date.getTime()+86400000L);
        student.setaClass(classService.findClassByIdClass(idClass));
        student.setDateOfBirth(dateSql);
        student.setName(name);
        student.setSurname(surname);
        studentService.editStudent(student);
        return "redirect:/mainAdmin/students";
    }



    @GetMapping("/teachers")
    public String adminTeachers(@RequestParam(value = "surname",required = false) String surname,
                                @RequestParam(value = "name",required = false) String name,
                                @AuthenticationPrincipal AccountUserDetails account, Map<String,Object> map){
        List<Teacher> teachers=null;
        if ((surname==null&& name==null)||(surname.isEmpty() && name.isEmpty()))
            teachers=teacherService.findAll();
        else if (surname.isEmpty() && !name.isEmpty())
            teachers=teacherService.findTeacherByName(name);
        else if (!surname.isEmpty() && name.isEmpty())
            teachers=teacherService.findTeacherBySurName(surname);
        else
            teachers=teacherService.findTeacherBySurNameAndName(surname,name);
        map.put("teacherList",teachers);
        return "admin/adminTeachers";
    }

    @GetMapping("/teacherEditor")
    public String teacherEditor(@RequestParam(value = "idTeacher",required = false) Long idTeacher,
                                @AuthenticationPrincipal AccountUserDetails account, Map<String,Object> map){
        if (idTeacher!=null)
            map.put("teacher",teacherService.findTeacherByIdTeacher(idTeacher));
        map.put("classes",classService.findAll());

        return "admin/adminTeacherEditor";
    }

    @RequestMapping(value = "/addTeacher", method = RequestMethod.POST)
    public String addTeacher(@RequestParam(value = "surname") String surname,
                             @RequestParam(value = "name") String name,
                             @RequestParam(value="aClass")Long idClass,
                             @RequestParam(value="dateOfBirth")String dateS){
        Teacher newTeacher= new Teacher();
        java.util.Date date=null;

        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(dateS);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date dateSql = new Date(date.getTime()+86400000L);
        newTeacher.setaClass(classService.findClassByIdClass(idClass));
        newTeacher.setDateOfBirth(dateSql);
        newTeacher.setName(name);
        newTeacher.setSurname(surname);
        teacherService.addTeacher(newTeacher);
        return "redirect:/mainAdmin/teachers";
    }
    @RequestMapping(value = "/editTeacher", method = RequestMethod.POST)
    public String editTeacher(@RequestParam(value = "idTeacher") Long id,
                              @RequestParam(value = "surname") String surname,
                              @RequestParam(value = "name") String name,
                              @RequestParam(value="aClass")Long idClass,
                              @RequestParam(value="dateOfBirth")String dateS){
        Teacher teacher= teacherService.findTeacherByIdTeacher(id);
        java.util.Date date=null;

        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(dateS);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date dateSql = new Date(date.getTime()+86400000L);
        teacher.setaClass(classService.findClassByIdClass(idClass));
        teacher.setDateOfBirth(dateSql);
        teacher.setName(name);
        teacher.setSurname(surname);
        teacherService.updateTeacher(teacher);
        return "redirect:/mainAdmin/teachers";
    }
    @GetMapping(value = "/classes")
    public String showClasses(Map<String,Object> map){
        map.put("classes",classService.findAll());
        return "admin/adminClasses";
    }
    @RequestMapping(value = "/addClass", method = RequestMethod.POST)
    public String addClass(@RequestParam(value = "name") String name){
        Class newClass = new Class();
        newClass.setName(name);
        classService.addClass(newClass);
        System.out.println("AUUU CHECKING IDDDDDD"+newClass.getIdclass());
        return "redirect:/mainAdmin/classes";
    }

    @GetMapping(value = "/subjects")
    public String showSubjects(Map<String,Object> map){
        map.put("subjects",subjectService.findAll());
        return "admin/adminSubjects";
    }
    @RequestMapping(value = "/addSubject", method = RequestMethod.POST)
    public String addSubject(@RequestParam(value = "name") String name){
        Subject newSubject = new Subject();
        newSubject.setName(name);
        subjectService.addSubject(newSubject);
        return "redirect:/mainAdmin/subjects";
    }
    @GetMapping(value = "/tsc")
    public String showTSC(@RequestParam(value="idClass", required = false)Long idClass,
                           Map<String,Object> map){
        map.put("classes",classService.findAll());
        if (idClass!=null) {
            map.put("idClass", idClass);
            map.put("teachers",teacherService.findAll());
            map.put("subjects",subjectService.findAll());
            map.put("tsc",tsc.findTSCByIdClass(idClass));
        }
        return "admin/adminSubjectsClass";
    }
    @RequestMapping(value = "/addTSC", method = RequestMethod.POST)
    public String addTSC(@RequestParam(value = "idClass") Long idClass,
                         @RequestParam(value = "idSubject") Long idSubject,
                         @RequestParam(value = "idTeacher") Long idTeacher){
        TeacherSubjectClass newTSC = new TeacherSubjectClass();
        newTSC.setaClass(classService.findClassByIdClass(idClass));
        newTSC.setSubject(subjectService.findSubjectByIdSubject(idSubject));
        newTSC.setTeacher(teacherService.findTeacherByIdTeacher(idTeacher));
        tsc.addTSC(newTSC);
        return "redirect:/mainAdmin/tsc?idClass="+idClass;
    }
    @GetMapping(value = "/plan")
    public String showPlan(@RequestParam(value="idClass", required = false)Long idClass,
            Map<String,Object> map){
        map.put("classes",classService.findAll());

        if (idClass!=null) {

            map.put("idClass", idClass);
            map.put("datesString", timeTableService.findAll());
            map.put("lessonTime", timeTableService.findAllLessonTime());
            map.put("timeTable", timeTableService.findTimeTableByIdClass(idClass));
            map.put("tsc",tsc.findTSCByIdClass(idClass));
            map.put("teachers",teacherService.findAll());
            map.put("subjects",subjectService.findAll());
        }
        return "admin/adminPlan";
    }
    @RequestMapping(value = "/savePlan", method = RequestMethod.POST)
    public String showPlan(@RequestParam(value="idClass")Long idClass,
                           @RequestParam(value = "idTSC") ArrayList<Long> idTSC){
        ArrayList<TeacherSubjectClass> teacherSubjectClasses = new ArrayList<>();
        for (Long id:idTSC) {
            if (id!=null)
            teacherSubjectClasses.add(tsc.findTSCByIdTSC(id));
            else
                teacherSubjectClasses.add(null);
        }
        for (TeacherSubjectClass tsc: teacherSubjectClasses) {
            System.out.println( tsc);
        }
        timeTableService.saveTimeTable(teacherSubjectClasses,idClass);

        return "redirect:/mainAdmin/plan?idClass="+idClass;
    }



}
