package com.unioeste.academus.controllers;

import com.unioeste.academus.models.Course;
import com.unioeste.academus.repositories.CourseRepository;
import com.unioeste.academus.services.CourseService;
import com.unioeste.academus.views.CourseView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseView courseView;

    public void findAll(){
        List<Course> courses = courseService.findAll();

        courseView.showCoursesTable(courses);
    }
}
