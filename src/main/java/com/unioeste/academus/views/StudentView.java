package com.unioeste.academus.views;

import com.unioeste.academus.models.CourseEnrollment;
import com.unioeste.academus.models.Student;
import com.unioeste.academus.models.SubjectClass;
import com.unioeste.academus.utils.ViewUtils;
import de.vandermeer.asciitable.AsciiTable;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

@Component
public class StudentView extends ViewUtils {
    public void showStudents(List<Student> students){
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

    public void showStudent(Student student){
        AsciiTable table = new AsciiTable();

        CourseEnrollment courseEnrollment = student.getCourseEnrollment();

        table.addRule();
        table.addRow("CPF", student.getCode());
        table.addRule();
        table.addRow("Nome", student.getName());
        table.addRule();
        table.addRow("E-mail", student.getEmail());
        table.addRule();
        table.addRow("Telefone", student.getPhoneNumber());
        table.addRule();
        table.addRow("Curso", courseEnrollment.getCourse().getName());
        table.addRule();
        table.addRow("N° da matricula", courseEnrollment.getNumber());
        table.addRule();
        table.addRow("Data de matricula", courseEnrollment.getDate().toString());
        table.addRule();

        System.out.println(table.render());
    }

    public List<Long> inputSubjectsClassesToEnroll(){
        String response = input("Para matricular o aluno, informe os códigos (ID) das turmas disponíveis separados por virgula: ");
        List<String> ids = Arrays.asList(response.split(","));

        return ids.stream().map(String::trim).map(Long::parseLong).toList();
    }

    public void showMenu(){
        super.showMenu(
                "[0] - Voltar",
                "[1] - Listar alunos",
                "[2] - Listar disciplinas de uma aluno",
                "[3] - Listar turmas de um aluno",
                "[4] - Matricular aluno"
        );
    }
}
