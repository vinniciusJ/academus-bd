package com.unioeste.academus.services;

import com.unioeste.academus.exceptions.NotFoundException;
import com.unioeste.academus.models.Course;
import com.unioeste.academus.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> findAll(){
        return courseRepository.findAll();
    }

    public void save(Course course){
        courseRepository.save(course);
    }

    public void delete(Long courseId){
        if(courseRepository.existsById(courseId)){
            courseRepository.deleteById(courseId);

            return;
        }

        throw new NotFoundException("Curso não encontrado com id " + courseId);
    }

    public Course findById(Long courseId) {
        return courseRepository.findById(courseId).orElseThrow(() -> new NotFoundException("Curso não encontrado com id " + courseId));
    }

    public boolean existsById(Long courseId) {
        return courseRepository.existsById(courseId);
    }
}
