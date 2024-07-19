package com.unioeste.academus.views;

import com.unioeste.academus.models.entities.CourseEnrollment;
import com.unioeste.academus.models.entities.Student;
import com.unioeste.academus.utils.ViewUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class StudentView extends ViewUtils {
    public void showUsers(List<Student> students){
        List<String> headers = List.of("ID", "CPF", "Name", "E-mail", "Telefone", "Endereço", "N° da matricula", "Curso", "Data de matricula");

        Function<Student, List<String>> renderStudentRow = student -> {
            CourseEnrollment courseEnrollment = student.getCourseEnrollment();

            return List.of(
                    student.getId().toString(),
                    student.getCode(),
                    student.getName(),
                    student.getEmail(),
                    student.getPhoneNumber(),
                    student.getAddress().toString(),
                    courseEnrollment.getNumber().toString(),
                    courseEnrollment.getCourse().getName(),
                    courseEnrollment.getDate().toString()
            );
        };

        showTable(headers, students, renderStudentRow);
    }

    public void showMenu(){
        super.showMenu(
                "[0] - Voltar",
                "[1] - Listar alunos",
                "[2] - Listar matrículas",
                "[3] - Matricular aluno"
        );
    }
}
