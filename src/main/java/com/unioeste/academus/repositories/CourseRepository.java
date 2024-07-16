package com.unioeste.academus.repositories;

import com.unioeste.academus.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
