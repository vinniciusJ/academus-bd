package com.unioeste.academus.services;

import com.unioeste.academus.models.entities.Professor;
import com.unioeste.academus.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> getAll() {
        return professorRepository.findAll();
    }
}
