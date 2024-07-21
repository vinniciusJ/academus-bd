package com.unioeste.academus.repositories;

import com.unioeste.academus.models.entities.SubjectClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectClassRepository extends JpaRepository<SubjectClass, Long> {

    @Query("SELECT subject_class FROM SubjectClass subject_class " +
            "LEFT JOIN FETCH subject_class.academicYear academic_year " +
            "LEFT JOIN FETCH subject_class.subject subject " +
            "LEFT JOIN FETCH subject_class.professor professor")
    public List<SubjectClass> findAll();
}
