package com.example.springbootuniversityprojects.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {

    @NotNull
    @Min(1)
    private int id;

    @NotBlank
    @NotNull
    private String projectTitle;

    @NotNull
    private Boolean availability;

}
