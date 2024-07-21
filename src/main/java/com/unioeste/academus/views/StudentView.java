package com.unioeste.academus.views;

import com.unioeste.academus.models.entities.Student;
import com.unioeste.academus.utils.ViewUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class StudentView extends ViewUtils {
    public void showAll(List<Student> academicYears){
        List<String> headers = List.of("Id", "Nome", "CPF", "Email", "Telefone",  "Endereço");

        Function<Student, List<String>> renderStudentRows = (student) -> List.of(
                student.getId().toString(),
                student.getName(),
                student.getCode(),
                student.getEmail(),
                student.getPhoneNumber(),
                student.getAddress().getFormattedAddress()
        );

        showTable(headers, academicYears, renderStudentRows);
    }

}
