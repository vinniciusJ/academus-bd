package com.unioeste.academus.services;

import com.unioeste.academus.models.entities.Subject;
import com.unioeste.academus.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> getSubjects() {
        return subjectRepository.findAll();
    }
}
