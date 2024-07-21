package com.unioeste.academus.models;

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
    @JoinColumn(name = "subject_class_id")
    private SubjectClass subjectClass;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public SubjectClassEnrollment(SubjectClass subjectClass, Student student) {
        this.subjectClass = subjectClass;
        this.student = student;
    }
}
