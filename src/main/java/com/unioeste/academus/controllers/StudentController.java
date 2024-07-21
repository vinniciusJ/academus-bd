package com.unioeste.academus.controllers;

import com.unioeste.academus.exceptions.NotFoundException;
import com.unioeste.academus.models.AcademicYear;
import com.unioeste.academus.models.Student;
import com.unioeste.academus.models.Subject;
import com.unioeste.academus.models.SubjectClass;
import com.unioeste.academus.services.AcademicYearService;
import com.unioeste.academus.services.StudentService;
import com.unioeste.academus.views.AcademicYearView;
import com.unioeste.academus.views.StudentView;
import com.unioeste.academus.views.SubjectClassView;
import com.unioeste.academus.views.SubjectView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private AcademicYearService academicYearService;

    @Autowired
    private AcademicYearView academicYearView;

    @Autowired
    private StudentView studentView;

    @Autowired
    private SubjectClassView subjectClassView;

    @Autowired
    private SubjectView subjectView;


    public void handleStudentsList(){
        List<Student> students = studentService.getAll();

        studentView.showStudents(students);
    }

    public void handleStudentSubjectList(){
        String studentCode = studentView.input("Digite o CPF do estudante: ");
        List<Subject> subjects = studentService.getSubjectsByStudent(studentCode);

        subjectView.showAll(subjects);
    }

    public void handleStudentSubjectClassesList(){
        String studentCode = studentView.input("Digite o CPF do estudante: ");
        List<SubjectClass> subjectsClasses = studentService.getStudentSubjectClasses(studentCode);

        subjectClassView.showAll(subjectsClasses);
    }

    public void handleStudentSubjectEnrollment(){
        String studentCode = studentView.input("Digite o CPF do estudante: ");

        Student student = studentService.getStudentByCode(studentCode);
        AcademicYear currentAcademicYear = academicYearService.getCurrentAcademicYear();
        List<SubjectClass> subjectsClasses = studentService.getAvailableSubjectClassesForStudent(studentCode);

        studentView.showStudent(student);
        academicYearView.showCurrentAcademicYear(currentAcademicYear);
        studentView.showMessage("Abaixo estão as turmas que o aluno(a) " + student.getName() + " pode se matricular");
        subjectClassView.showAll(subjectsClasses);

        List<Long> ids = studentView.inputSubjectsClassesToEnroll();

        try {
            studentService.enrollUserWithSubjectsClasses(studentCode, ids);
        }catch (NotFoundException notFoundException){
            studentView.showError(notFoundException);
        }
    }

    public void startMenu(){
        studentView.showMenu();

        int option = studentView.input("Escolha uma das opções acima: ", Integer::parseInt);

        switch (option) {
            case 0 -> {
                return;
            }
            case 1 -> handleStudentsList();
            case 2 -> handleStudentSubjectList();
            case 3 -> handleStudentSubjectClassesList();
            case 4 -> handleStudentSubjectEnrollment();
            default -> startMenu();
        }

        startMenu();
    }
}
