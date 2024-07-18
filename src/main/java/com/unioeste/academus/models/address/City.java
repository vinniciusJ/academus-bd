package com.unioeste.academus.models.address;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "city")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    private FederalUnit federalUnit;
}
