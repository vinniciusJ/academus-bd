package com.unioeste.academus.models;

import com.unioeste.academus.models.address.Address;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "student")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class Student extends Person {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private CourseEnrollment courseEnrollment;

    @OneToOne
    private Address address;
}
