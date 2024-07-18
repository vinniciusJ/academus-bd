package com.unioeste.academus.models.address;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "public_area_type")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class PublicAreaType {
    @Id
    private String acronym;

    private String name;

    @OneToMany
    private List<PublicArea> addresses;
}
