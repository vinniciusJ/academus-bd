package com.unioeste.academus.views;

import com.unioeste.academus.models.SubjectClass;
import com.unioeste.academus.utils.ViewUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class SubjectClassView extends ViewUtils {
    public void showAll(List<SubjectClass> subjects) {
        List<String> headers = List.of("ID", "Ano letivo", "Nome", "Disciplina", "Professor");

        Function<SubjectClass, List<String>> renderSubjectClassRow = (subjectClass) -> List.of(
                subjectClass.getId().toString(),
                subjectClass.getAcademicYear().getYear().toString(),
                subjectClass.getName(),
                subjectClass.getSubject().getName(),
                subjectClass.getProfessor().getName()
        );

        showTable(headers, subjects, renderSubjectClassRow);
    }
}
