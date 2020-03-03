package com.example.demo.controller;


import com.example.demo.domain.*;
import com.example.demo.domain.Class;
import com.example.demo.security.AccountUserDetails;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountRoleService accountRoleService;
//    @Autowired
//    private StudentRepository studentRepository;

    @GetMapping
    public String adminMainPage(@AuthenticationPrincipal AccountUserDetails account, Map<String,Object> map){

        return "admin/adminMainPage";
    }

    @GetMapping("/students")
    public String adminStudents(@RequestParam(value = "surname",required = false) String surname,
                                @RequestParam(value = "name",required = false) String name,
                                @RequestParam(value = "page",required = false) Long page,
                                @RequestParam(value = "idClass",required = false) Long idClass,
            @AuthenticationPrincipal AccountUserDetails account, Map<String,Object> map){
        String url ="";
        if (page==null)
            page=0L;

        PagedListHolder<Student> studentPage=null;

        if ((surname==null&& name==null)||(surname.isEmpty() && name.isEmpty()))
            studentPage= studentService.findAllPages(10,page.intValue());
           // students=studentService.findAll();
        else if (surname.isEmpty() && !name.isEmpty()){
            studentPage=studentService.findStudentByName(name,10,page.intValue());
            url="&name="+name+"&surname="+surname;
        }
        else if (!surname.isEmpty() && name.isEmpty()){
            studentPage=studentService.findStudentBySurName(surname,10,page.intValue());
            url="&name="+name+"&surname="+surname;
        }
        else {
            studentPage = studentService.findStudentBySurNameAndName(surname, name, 10, page.intValue());
            url="&name="+name+"&surname="+surname;
        }
        if (idClass!=null) {
            studentPage = studentService.findStudentsByIdClassPages(idClass, 5, page.intValue());
            url="&idClass="+idClass;
        }
        map.put("url",url);
        map.put("numPage",page);
        map.put("pageCount",studentPage.getPageCount());
        map.put("idClass",idClass);
        map.put("classes",classService.findAll());
        map.put("studentList",studentPage.getPageList());
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
                             @RequestParam(value="dateOfBirth")String dateS,
                             @RequestParam(value="address")String address,
                             @RequestParam(value="email")String email,
                             @RequestParam(value="phone")String phone){
        Student newStudent= new Student();
        java.util.Date date=null;
        Account newAccount = new Account();

        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(dateS);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date dateSql = new Date(date.getTime()+86400000L);
        if (idClass!=null)
        newStudent.setaClass(classService.findClassByIdClass(idClass));
        newStudent.setDateOfBirth(dateSql);
        newStudent.setName(name);
        newStudent.setSurname(surname);
            newStudent.setAddress(address);
            newStudent.setEmail(email);
            newStudent.setPhone(phone);
        studentService.addStudent(newStudent);

        newAccount.setUsername(newStudent.getIdstudent().toString()+"u");
        newAccount.setPassword(newStudent.getIdstudent().toString());
        newAccount.setAccountRole(accountRoleService.findAcRoleById(1L));
        accountService.addAccount(newAccount);
        newStudent.setAccount(newAccount);
        studentService.editStudent(newStudent);
        return "redirect:/mainAdmin/students";
    }
    @RequestMapping(value = "/editStudent", method = RequestMethod.POST)
    public String editStudent(@RequestParam(value = "idStudent") Long id,
                             @RequestParam(value = "surname") String surname,
                             @RequestParam(value = "name") String name,
                             @RequestParam(value="aClass")Long idClass,
                             @RequestParam(value="dateOfBirth")String dateS,
                              @RequestParam(value="address")String address,
                              @RequestParam(value="email")String email,
                              @RequestParam(value="phone")String phone){
        Student student= studentService.findStudentByIdStudent(id);
        java.util.Date date=null;

        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(dateS);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date dateSql = new Date(date.getTime()+86400000L);
        if (idClass!=null)
        student.setaClass(classService.findClassByIdClass(idClass));
        else
            student.setaClass(null);
        student.setDateOfBirth(dateSql);
        student.setName(name);
        student.setSurname(surname);
            student.setAddress(address);
            student.setEmail(email);
            student.setPhone(phone);
        studentService.editStudent(student);
        return "redirect:/mainAdmin/students";
    }

    @RequestMapping(value = "/deleteStudent", method = RequestMethod.POST)
    public String deleteStudent(@RequestParam(value = "idStudent") Long id){
        studentService.deleteStudent(studentService.findStudentByIdStudent(id));
        accountService.deleteAccount(accountService.findAccountByUsername(id+"u"));
        return "redirect:/mainAdmin/students";
    }



    @GetMapping("/teachers")
    public String adminTeachers(@RequestParam(value = "surname",required = false) String surname,
                                @RequestParam(value = "name",required = false) String name,
                                @RequestParam(value = "page",required = false) Long page,
                                @AuthenticationPrincipal AccountUserDetails account, Map<String,Object> map){
        String url ="";
        if (page==null)
            page=0L;

        PagedListHolder<Teacher> teacherPage=null;
        if ((surname==null&& name==null)||(surname.isEmpty() && name.isEmpty()))
            teacherPage=teacherService.findAll(10,page.intValue());
        else if (surname.isEmpty() && !name.isEmpty()){
            teacherPage=teacherService.findTeacherByName(name,10,page.intValue());
            url="&name="+name+"&surname="+surname;
        }
        else if (!surname.isEmpty() && name.isEmpty()){
            teacherPage=teacherService.findTeacherBySurName(surname,10,page.intValue());
            url="&name="+name+"&surname="+surname;
        }
        else{
            teacherPage=teacherService.findTeacherBySurNameAndName(surname,name,10,page.intValue());
            url="&name="+name+"&surname="+surname;
        }
        map.put("url",url);
        map.put("numPage",page);
        map.put("pageCount",teacherPage.getPageCount());
        map.put("teacherList",teacherPage.getPageList());
        return "admin/adminTeachers";
    }

    //teacherEditorBellow
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
                             @RequestParam(value="dateOfBirth")String dateS,
                             @RequestParam(value="address")String address,
                             @RequestParam(value="email")String email,
                             @RequestParam(value="phone")String phone){
        Teacher newTeacher= new Teacher();
        java.util.Date date=null;
        Account newAccount = new Account();

        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(dateS);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date dateSql = new Date(date.getTime()+86400000L);
        if (idClass!=null)
        newTeacher.setaClass(classService.findClassByIdClass(idClass));
        newTeacher.setDateOfBirth(dateSql);
        newTeacher.setName(name);
        newTeacher.setSurname(surname);
            newTeacher.setAddress(address);
            newTeacher.setEmail(email);
            newTeacher.setPhone(phone);
        teacherService.addTeacher(newTeacher);
        newAccount.setUsername(newTeacher.getIdTeacher().toString()+"n");
        newAccount.setPassword(newTeacher.getIdTeacher().toString());
        newAccount.setAccountRole(accountRoleService.findAcRoleById(2L));
        accountService.addAccount(newAccount);
        newTeacher.setAccount(newAccount);
       teacherService.updateTeacher(newTeacher);

        return "redirect:/mainAdmin/teachers";
    }
    @RequestMapping(value = "/editTeacher", method = RequestMethod.POST)
    public String editTeacher(@RequestParam(value = "idTeacher") Long id,
                              @RequestParam(value = "surname") String surname,
                              @RequestParam(value = "name") String name,
                              @RequestParam(value="aClass")Long idClass,
                              @RequestParam(value="dateOfBirth")String dateS,
                              @RequestParam(value="address")String address,
                              @RequestParam(value="email")String email,
                              @RequestParam(value="phone")String phone){
        Teacher teacher= teacherService.findTeacherByIdTeacher(id);
        java.util.Date date=null;

        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(dateS);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date dateSql = new Date(date.getTime()+86400000L);
        if (idClass!=null)
        teacher.setaClass(classService.findClassByIdClass(idClass));
        else
            teacher.setaClass(null);
        teacher.setDateOfBirth(dateSql);
        teacher.setName(name);
        teacher.setSurname(surname);
            teacher.setAddress(address);
            teacher.setEmail(email);
            teacher.setPhone(phone);
        teacherService.updateTeacher(teacher);
        return "redirect:/mainAdmin/teachers";
    }
    @RequestMapping(value = "/deleteTeacher", method = RequestMethod.POST)
    public String deleteTeacher(@RequestParam(value = "idTeacher") Long id){
        timeTableService.deleteByTSC(tsc.findTSCByIdTeacher(id));
        tsc.deleteByTeacher(id);
        teacherService.deleteTeacher(teacherService.findTeacherByIdTeacher(id));
        accountService.deleteAccount(accountService.findAccountByUsername(id+"n"));
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
    @RequestMapping(value = "/deleteClass", method = RequestMethod.POST)
    public String deleteClass(@RequestParam(value = "idClass") Long id){
        studentService.deleteClassInStudents(id);
        timeTableService.deleteByTSC(tsc.findTSCByIdClass(id));
        tsc.deleteByClass(id);
        classService.deleteClass(classService.findClassByIdClass(id));
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

    @RequestMapping(value = "/deleteSubject", method = RequestMethod.POST)
    public String deleteSubject(@RequestParam(value = "idSubject") Long id){

        timeTableService.deleteByTSC(tsc.findTSCByIdSubject(id));
        tsc.deleteBySubject(id);
       subjectService.deleteSubject(subjectService.findSubjectByIdSubject(id));
        return "redirect:/mainAdmin/subjects";
    }

    @GetMapping(value = "/tsc")
    public String showTSC(@RequestParam(value="idClass", required = false)Long idClass,
                           Map<String,Object> map){
        map.put("classes",classService.findAll());
        if (idClass!=null) {
            map.put("classId",idClass);
            map.put("aClass", classService.findClassByIdClass(idClass));
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

    @RequestMapping(value = "/deleteTSC", method = RequestMethod.POST)
    public String deleteTSC(@RequestParam(value = "idTSC") Long id){


        timeTableService.deleteByTSC(tsc.findTSCByIdTSC(id));
        tsc.deleteTSC(tsc.findTSCByIdTSC(id));
        return "redirect:/mainAdmin/tsc";
    }

    @GetMapping(value = "/plan")
    public String showPlan(@RequestParam(value="idClass", required = false)Long idClass,
            Map<String,Object> map){
        map.put("classes",classService.findAll());

        if (idClass!=null) {

            map.put("classId", idClass);
            map.put("aClass", classService.findClassByIdClass(idClass));
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
