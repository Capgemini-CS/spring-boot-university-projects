package com.example.springbootuniversityprojects.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher extends Person {
    private List<Project> projectList;
    private List<Student> coordinatedStudentsList;

}
