package com.unioeste.academus.models.entities.address;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "address")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class Address {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "zip_code")
    private String zipCode;

    private String neighborhood;

    @ManyToOne
    private PublicArea publicArea;

    @ManyToOne
    private City city;

    public String getFormattedAddress() {
        return String.format("%s - %s, %s - %s, %s", publicArea.getName(), neighborhood, city.getName(), city.getFederalUnit().getAcronym(), zipCode);
    }
}
