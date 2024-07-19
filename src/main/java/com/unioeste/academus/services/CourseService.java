package com.unioeste.academus.services;

import com.unioeste.academus.exceptions.NotFoundException;
import com.unioeste.academus.models.dtos.CourseDTO;
import com.unioeste.academus.models.entities.Course;
import com.unioeste.academus.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAll(){
        return courseRepository.findAll();
    }
}
