package com.unioeste.academus.services;

import com.unioeste.academus.models.entities.SubjectClass;
import com.unioeste.academus.repositories.SubjectClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectClassService {
    @Autowired
    private SubjectClassRepository subjectClassRepository;

    public List<SubjectClass> getSubjects() {
        return subjectClassRepository.findAll();
    }
}
