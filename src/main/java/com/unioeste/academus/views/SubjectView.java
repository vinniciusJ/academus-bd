package com.unioeste.academus.views;

import com.unioeste.academus.models.entities.Subject;
import com.unioeste.academus.utils.ViewUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class SubjectView extends ViewUtils {
    public void showAll(List<Subject> subjects) {
        List<String> headers = List.of("ID", "Serie", "Nome", "Curso");

        Function<Subject, List<String>> renderSubjectRow = (subject) -> List.of(
                subject.getId().toString(),
                subject.getSeries().toString(),
                subject.getName(),
                subject.getCourse().getName()
        );

        showTable(headers, subjects, renderSubjectRow);
    }
}
