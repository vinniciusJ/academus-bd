package com.unioeste.academus.views;

import com.unioeste.academus.models.Professor;
import com.unioeste.academus.utils.ViewUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class ProfessorView extends ViewUtils {
    public void showAll(List<Professor> professors){
        List<String> headers = List.of("Id", "Nome", "CPF", "Email", "Telefone",  "Endereço");

        Function<Professor, List<String>> renderProfessorRows = (professor) -> List.of(
                professor.getId().toString(),
                professor.getName(),
                professor.getCode(),
                professor.getEmail(),
                professor.getPhoneNumber(),
                professor.getAddress().toString()
        );

        showTable(headers, professors, renderProfessorRows);
    }

}
