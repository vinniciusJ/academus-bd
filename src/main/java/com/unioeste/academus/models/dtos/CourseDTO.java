package com.unioeste.academus.models.dtos;

import com.unioeste.academus.models.entities.Subject;
import lombok.*;

import java.util.List;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class CourseDTO {
    private Long id;
    private String name;
    private List<Subject> subjects;
}
