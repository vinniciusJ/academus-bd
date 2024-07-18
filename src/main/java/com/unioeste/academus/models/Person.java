package com.unioeste.academus.models;

import jakarta.persistence.MappedSuperclass;
import lombok.*;

@MappedSuperclass
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class Person {
    private String name;
    private String code;
    private String email;
    private String phoneNumber;
}
