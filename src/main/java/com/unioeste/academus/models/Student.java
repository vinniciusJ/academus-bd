package com.unioeste.academus.models;

import com.unioeste.academus.models.address.Address;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "student")
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class Student extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Address address;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private CourseEnrollment courseEnrollment;
}