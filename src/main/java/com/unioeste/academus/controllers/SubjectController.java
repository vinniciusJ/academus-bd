package com.unioeste.academus.controllers;

import com.unioeste.academus.models.entities.Subject;
import com.unioeste.academus.services.SubjectService;
import com.unioeste.academus.views.SubjectView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @Autowired
    private SubjectView subjectView;

    public void handleSubjectsList(){
        List<Subject> subjects = subjectService.getSubjects();

        subjectView.showAll(subjects);
    }
}
