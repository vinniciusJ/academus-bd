package com.unioeste.academus.views;


import com.unioeste.academus.models.Course;
import com.unioeste.academus.utils.ViewUtils;
import de.vandermeer.asciitable.AsciiTable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseView extends ViewUtils {
    public void showCourses(List<Course> courses){
        AsciiTable coursesTable = new AsciiTable();

        coursesTable.addRule();
        coursesTable.addRow("ID", "Name");
        coursesTable.addRule();

        for(Course course : courses){
            coursesTable.addRow(course.getId(), course.getName());
            coursesTable.addRule();
        }

        System.out.println(coursesTable.render());
    }

    public void showCourse(Course course){
        AsciiTable coursesTable = new AsciiTable();

        coursesTable.addRule();
        coursesTable.addRow("ID", course.getId());
        coursesTable.addRule();
        coursesTable.addRow("Name", course.getName());
        coursesTable.addRule();

        System.out.println(coursesTable.render());
    }

    public Course inputCourse(){
        Course course = new Course();

        course.setName(input("Digite o nome do curso: "));

        return course;
    }

    public void showMenu() {
        super.showMenu(
                "[0] - Voltar",
                "[1] - Listar todos os cursos",
                "[2] - Listar curso por ID",
                "[3] - Cadastrar curso",
                "[4] - Editar curso",
                "[5] - Excluir curso"
        );
    }
}
