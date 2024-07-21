package com.unioeste.academus.repositories;

import com.unioeste.academus.models.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    @Query("SELECT professor FROM Professor professor")
    public List<Professor> findAll();
}
