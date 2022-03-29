package com.example.springbootuniversityprojects.service.mapper;

import com.example.springbootuniversityprojects.domain.Project;
import com.example.springbootuniversityprojects.domain.dto.ProjectDto;

public class ProjectMapper {

    public static ProjectDto projectToProjectDto(Project project){
        ProjectDto projectDto = new ProjectDto();
        projectDto.setId(project.getId());
        projectDto.setProjectTitle(project.getProjectTitle());
        projectDto.setAvailability(project.getAvailability());
        return projectDto;
    }

    public static Project projectDtoToProject(ProjectDto projectDto){
        Project project = new Project();
        project.setId(project.getId());
        project.setProjectTitle(project.getProjectTitle());
        project.setAvailability(project.getAvailability());
        return project;
    }

}
