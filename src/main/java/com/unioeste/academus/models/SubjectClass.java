package com.unioeste.academus.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "subject_class")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class SubjectClass {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "academic_year_year")
    private AcademicYear academicYear;
}
