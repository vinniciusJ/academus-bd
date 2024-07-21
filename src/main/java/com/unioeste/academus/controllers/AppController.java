package com.unioeste.academus.controllers;

import com.unioeste.academus.views.AppView;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class AppController {
    @Autowired
    private AppView appView;

    @Autowired
    private AcademicYearController academicYearController;

    @Autowired
    private CourseController courseController;

    @Autowired
    private SubjectController subjectController;

    @Autowired
    private SubjectClassController subjectClassController;
    @Autowired
    private ProfessorController professorController;
    @Autowired
    private StudentController studentController;

    public void startApp(){
        appView.showMenu();

        int option = appView.input("Escolha uma das opções acima: ", Integer::parseInt);

        switch (option){
            case 0 -> System.exit(0);
            case 1 -> courseController.handleCoursesList();
            case 2 -> subjectController.handleSubjectsList();
            case 3 -> academicYearController.handleAcademicYearList();
            case 4 -> subjectClassController.handleSubjectClassList();
            case 5 -> professorController.handleProfessorList();
            case 6 -> studentController.handleStudentList();
            default -> startApp();
        }

        startApp();
    }
}
