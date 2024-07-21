package com.unioeste.academus.controllers;

import com.unioeste.academus.models.entities.Student;
import com.unioeste.academus.services.StudentService;
import com.unioeste.academus.views.StudentView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentView studentView;

    public void handleStudentList(){
        List<Student> students = studentService.getAll();

        studentView.showAll(students);
    }

}
