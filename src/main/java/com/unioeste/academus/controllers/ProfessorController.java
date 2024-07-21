package com.unioeste.academus.controllers;

import com.unioeste.academus.models.Professor;
import com.unioeste.academus.services.ProfessorService;
import com.unioeste.academus.views.ProfessorView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    @Autowired
    private ProfessorView professorView;

    public void handleProfessorList(){
        List<Professor> professors = professorService.getAll();

        professorView.showAll(professors);
    }

}
