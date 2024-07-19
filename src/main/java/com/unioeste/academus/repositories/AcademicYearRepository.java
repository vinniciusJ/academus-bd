package com.unioeste.academus.repositories;

import com.unioeste.academus.models.entities.AcademicYear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcademicYearRepository extends JpaRepository<AcademicYear, Long> {
    @Query("SELECT academic_year FROM AcademicYear academic_year")
    public List<AcademicYear> findAll();
}