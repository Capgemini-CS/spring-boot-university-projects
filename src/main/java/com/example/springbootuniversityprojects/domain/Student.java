package com.example.springbootuniversityprojects.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student extends Person {

    private Project alocatedProject;
    private Teacher coordinatorTeacher;
}
