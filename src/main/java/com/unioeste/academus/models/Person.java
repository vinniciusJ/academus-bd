package com.unioeste.academus.models;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class Person {
    private String name;
    private String code;
    private String email;
    private String phoneNumber;
}
