package com.unioeste.academus.models.entities;

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

    @ManyToOne
    private AcademicYear academicYear;

    @ManyToOne
    private Subject subject;

    @ManyToOne
    private Professor professor;
}
