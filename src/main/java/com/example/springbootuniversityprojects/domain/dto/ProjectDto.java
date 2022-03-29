package com.example.springbootuniversityprojects.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {

    private int id;
    private String projectTitle;
    private Boolean availability;

}
