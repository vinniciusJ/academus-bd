package com.unioeste.academus.models.address;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "public_area")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class PublicArea {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    private PublicAreaType publicAreaType;

    @OneToMany
    private List<Address> addresses;
}
