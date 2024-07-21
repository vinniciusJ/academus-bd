package com.unioeste.academus.views;

import com.unioeste.academus.models.Course;
import com.unioeste.academus.models.Subject;
import com.unioeste.academus.utils.ViewUtils;
import de.vandermeer.asciitable.AsciiTable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class CourseView extends ViewUtils {
    public void showAll(List<Course> courses){
        List<String> headers = List.of("ID", "Nome", "Disciplinas");

        Function<Course, List<String>> renderCourseRow = (course) -> List.of(
                course.getId().toString(),
                course.getName(),
                this.getSubjectsString(course.getSubjects())
        );

        showTable(headers, courses, renderCourseRow);
    }

    public void showCourse(Course course){
        AsciiTable table = new AsciiTable();

        table.addRule();
        table.addRow("Nome do curso: ", course.getName());
        table.addRule();

        System.out.println(table.render());
    }

    private String getSubjectsString(List<Subject> subjects){
        return subjects.stream().map(Subject::getName).collect(Collectors.joining(", "));
    }
}
