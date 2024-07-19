package com.unioeste.academus.services;

import com.unioeste.academus.models.entities.AcademicYear;
import com.unioeste.academus.repositories.AcademicYearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademicYearService {
    @Autowired
    private AcademicYearRepository academicYearRepository;

    public List<AcademicYear> getAll() {
        return academicYearRepository.findAll();
    }
}
