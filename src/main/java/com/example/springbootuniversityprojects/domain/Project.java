package com.example.springbootuniversityprojects.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    @NotNull
    private int id;

    @NotNull
    private String projectTitle;

    private Boolean availability;

}
