package com.unioeste.academus.models;

import com.unioeste.academus.models.address.Address;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "professor")
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class Professor extends Person {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Address address;
}