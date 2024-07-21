package com.unioeste.academus.controllers;

import com.unioeste.academus.models.SubjectClass;
import com.unioeste.academus.services.SubjectClassService;
import com.unioeste.academus.views.SubjectClassView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SubjectClassController {
    @Autowired
    private SubjectClassService subjectClassService;

    @Autowired
    private SubjectClassView subjectClassView;

    public void handleSubjectClassList(){
        List<SubjectClass> subjects = subjectClassService.getSubjects();

        subjectClassView.showAll(subjects);
    }
}
