package com.unioeste.academus.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "course_enrollment")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class CourseEnrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer number;

    private LocalDate date;

    @OneToOne
    private Student student;

    @ManyToOne
    private Course course;
}
