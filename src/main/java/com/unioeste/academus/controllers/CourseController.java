package com.unioeste.academus.controllers;

import com.unioeste.academus.exceptions.NotFoundException;
import com.unioeste.academus.models.Course;
import com.unioeste.academus.services.CourseService;
import com.unioeste.academus.views.CourseView;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseView courseView;

    public void handleCoursesList(){
        List<Course> courses = courseService.findAll();

        courseView.showCourses(courses);
    }

    public void handleCourseView(){
        Long courseId = courseView.input("Informe o ID do curso: ", Long::parseLong);

        try {
            Course course = courseService.findById(courseId);

            courseView.showCourse(course);
        }
        catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void handleCourseCreate(){
        Course course = courseView.inputCourse();

        courseService.save(course);
    }

    public void handleCourseUpdate(){
        Long id = courseView.input("Informe o ID do curso: ", Long::parseLong);

        if(!courseService.existsById(id)){
            System.out.println("Curso não encontrado com id " + id);
            return;
        }

        Course course = courseView.inputCourse();
        course.setId(id);

        courseService.save(course);
    }

    public void handleCourseDelete(){
        Long id = courseView.input("Informe o ID do curso: ", Long::parseLong);

        try {
            courseService.delete(id);
        }
        catch (NotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    public void startCourseMenu(){
        courseView.showMenu();

        int option = courseView.input("Escolha uma das opções acima: ", Integer::parseInt);

        if(option == 0){
            return;
        }

        switch (option) {
            case 1 -> handleCoursesList();
            case 2 -> handleCourseView();
            case 3 -> handleCourseCreate();
            case 4 -> handleCourseUpdate();
            case 5 -> handleCourseDelete();
            default -> System.out.println("Opção inválida");
        }

        startCourseMenu();
    }
}
