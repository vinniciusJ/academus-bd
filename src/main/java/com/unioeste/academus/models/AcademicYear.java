package com.unioeste.academus.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "academic_year")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class AcademicYear {
    @Id
    private Integer year;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;
}
