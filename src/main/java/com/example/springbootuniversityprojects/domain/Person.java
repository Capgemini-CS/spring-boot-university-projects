package com.example.springbootuniversityprojects.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
}
