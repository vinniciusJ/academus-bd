package com.unioeste.academus.repositories;

import com.unioeste.academus.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("SELECT course FROM Course course LEFT JOIN FETCH course.subjects")
    public List<Course> findAll();

//    @Query("SELECT subject FROM Subject subject WHERE subject.id == :courseId")
//    public List<Subject> findAllByCourse(@Param("courseId") Long courseId);
}
