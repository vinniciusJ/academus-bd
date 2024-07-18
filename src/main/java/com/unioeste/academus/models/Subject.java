package com.unioeste.academus.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "subject")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class Subject {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private Integer series;

    private String name;

    @ManyToOne
    private Course course;
}
