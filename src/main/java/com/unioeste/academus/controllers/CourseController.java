package com.unioeste.academus.controllers;

import com.unioeste.academus.models.Course;
import com.unioeste.academus.repositories.CourseRepository;
import com.unioeste.academus.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;

    public List<Course> findAll(){
        return courseService.findAll();
    }
}
