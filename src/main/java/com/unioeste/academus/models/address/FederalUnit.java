package com.unioeste.academus.models.address;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "federal_unit")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class FederalUnit {
    @Id
    private String acronym;

    private String name;
}
