package com.unioeste.academus.views;


import com.unioeste.academus.models.Course;
import de.vandermeer.asciitable.AsciiTable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseView {


    public void showCoursesTable(List<Course> courses){
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
}
