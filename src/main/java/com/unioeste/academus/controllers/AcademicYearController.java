package com.unioeste.academus.controllers;

import com.unioeste.academus.models.entities.AcademicYear;
import com.unioeste.academus.services.AcademicYearService;
import com.unioeste.academus.views.AcademicYearView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AcademicYearController {
    @Autowired
    private AcademicYearService academicYearService;

    @Autowired
    private AcademicYearView academicYearView;

    public void handleAcademicYearList(){
        List<AcademicYear> academicYears = academicYearService.getAll();

        academicYearView.showAll(academicYears);
    }

}
