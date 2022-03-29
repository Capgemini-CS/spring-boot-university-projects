package com.example.springbootuniversityprojects.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    private int id;
    private String projectTitle;
    private Boolean availability;
}
