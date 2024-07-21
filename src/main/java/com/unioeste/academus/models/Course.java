package com.unioeste.academus.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "course")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class Course {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "course")
    private List<Subject> subjects;
 }
