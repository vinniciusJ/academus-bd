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

    public void handleStudentsList(){
        List<Student> students = studentService.getStudents();

        studentView.showUsers(students);
    }

    public void startMenu(){
        studentView.showMenu();

        int option = studentView.input("Escolha uma das opções acima: ", Integer::parseInt);

        switch (option) {
            case 0 -> {
                return;
            }
            case 1 -> handleStudentsList();
            default -> startMenu();
        }

        startMenu();
    }
}
