package com.unioeste.academus.repositories;

import com.unioeste.academus.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

    @Query("SELECT subject FROM Subject subject LEFT JOIN Course course ON subject.id = course.id")
    public List<Subject> findAll();
}
