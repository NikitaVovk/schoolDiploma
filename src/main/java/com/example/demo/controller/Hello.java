package com.example.demo.controller;


import com.example.demo.dao.TeacherDao;
import com.example.demo.dao.TeacherSubjectClassDao;
import com.example.demo.domain.TeacherSubjectClass;
import com.example.demo.security.AccountUserDetails;
import com.example.demo.service.TeacherService;
import com.example.demo.service.TeacherSubjectClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class Hello {
//    @Autowired
//    private StudentRepo studentRepo;
//    @Autowired
//    private SubjectRepos subjectRepos;
//    @Autowired
//    private MarkRepo markRepo;


    @GetMapping("/")
    public String greeting(@RequestParam(name = "id",required = false,defaultValue = "1")int studentID,
                           Map<String,Object> modelMarks,
                           Map<String,Object> modelSubjects){

        return "greeting";
    }


//    @GetMapping("/mainStudent")
//    public String studentMainPage(@RequestParam(name = "id",required = false,defaultValue = "1")int studentID,
//                           Map<String,Object> modelMarks,
//                           Map<String,Object> modelSubjects){
////        Iterable<Marks> marks = markRepo.findAll();
////        modelMarks.put("marks",marks);
//////        List<Marks> marks=markRepo.getAll();
////        //List<Subject>subjects = null;
////        // modelMarks.put("marks",marks);
////        Iterable<Subject> subjects=null;
////        for (Marks mark: marks) {
////            System.out.println("HELLO"+subjectRepos.findSubjectByIdsubject(mark.getId_subject()).getName());
////        }
////        //modelSubjects.put("subjects",subjects);
//        return "studentMainPage";
//    }


}
