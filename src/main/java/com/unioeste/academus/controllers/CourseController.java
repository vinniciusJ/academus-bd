package com.unioeste.academus.controllers;

import com.unioeste.academus.models.entities.Course;
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

    public void handleCoursesList() {
        List<Course> courses = courseService.getAll();

        courseView.showAll(courses);
    }
}
