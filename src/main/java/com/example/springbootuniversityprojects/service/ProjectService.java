package com.example.springbootuniversityprojects.service;

import com.example.springbootuniversityprojects.domain.Project;
import com.example.springbootuniversityprojects.domain.dto.ProjectDto;
import com.example.springbootuniversityprojects.service.mapper.ProjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.tinylog.Logger;


@Service
public class ProjectService {


    public Project addProject(ProjectDto projectDto){
        Project project = ProjectMapper.projectDtoToProject(projectDto);
        project.setId(projectDto.getId());
        project.setProjectTitle(projectDto.getProjectTitle());
        project.setAvailability(projectDto.getAvailability());
        Logger.info("Project id {} saved", project.getId());
        return project;
    }

    public Project updateProject(int id, ProjectDto projectDto){
        Project project = ProjectMapper.projectDtoToProject(projectDto);
        project.setId(id);
        project.setProjectTitle(project.getProjectTitle());
        project.setAvailability(project.getAvailability());
        return project;
    }

    public void writeJSON(Project project) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("projects.json"), project);
    }


}
