package com.unioeste.academus.services;

import com.unioeste.academus.exceptions.NotFoundException;
import com.unioeste.academus.models.Student;
import com.unioeste.academus.models.Subject;
import com.unioeste.academus.models.SubjectClass;
import com.unioeste.academus.models.SubjectClassEnrollment;
import com.unioeste.academus.repositories.StudentRepository;
import com.unioeste.academus.repositories.SubjectClassEnrollmentRepository;
import com.unioeste.academus.repositories.SubjectClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectClassRepository subjectClassRepository;

    @Autowired
    private SubjectClassEnrollmentRepository subjectClassEnrollmentRepository;

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student getStudentByCode(String studentCode) {
        Student student = studentRepository.findByCode(studentCode);

        if(student == null) {
            throw new NotFoundException("Aluno não encontrado com CPF " + studentCode);
        }

        return student;
    }

    public List<SubjectClass> getAvailableSubjectClassesForStudent(String studentCode){
        Student student = studentRepository.findByCode(studentCode);

        return studentRepository.findAvailableSubjectClasses(student.getId());
    }

    public List<Subject> getSubjectsByStudent(String studentCode){
        Student student = studentRepository.findByCode(studentCode);

        return studentRepository.findAllSubjectsByStudentId(student.getId());
    }

    public List<SubjectClass> getStudentSubjectClasses(String studentCode){
        Student student = studentRepository.findByCode(studentCode);

        return studentRepository.findStudentSubjectClassesById(student.getId());
    }

    public void enrollUserWithSubjectsClasses(String studentCode, List<Long> subjectsClassesIds){
        Student student = studentRepository.findByCode(studentCode);

        if(student == null) {
            throw new NotFoundException("Usuário não encontrado com CPF: " + studentCode);
        }

        for(Long subjectClassId : subjectsClassesIds){
            SubjectClass subjectClass = subjectClassRepository.findById(subjectClassId).orElse(null);

            if(subjectClass == null) {
                throw new NotFoundException("Turma não encontrada com ID: " + subjectClassId);
            }

            subjectClassEnrollmentRepository.save(new SubjectClassEnrollment(subjectClass, student));
        }
    }

}
