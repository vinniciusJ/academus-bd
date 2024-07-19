package com.unioeste.academus.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "subject_class_enrollment")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class SubjectClassEnrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer number;

    @ManyToOne
    private Student student;

    @ManyToOne
    private SubjectClass subjectClass;
}
