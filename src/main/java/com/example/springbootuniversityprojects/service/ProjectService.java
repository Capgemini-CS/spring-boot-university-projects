package com.example.springbootuniversityprojects.service;

import com.example.springbootuniversityprojects.domain.Project;
import com.example.springbootuniversityprojects.domain.dto.ProjectDto;
import com.example.springbootuniversityprojects.exception.NoSuchProjectException;
import com.example.springbootuniversityprojects.service.mapper.ProjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.tinylog.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProjectService {

   private static List<Project> projectsList = new ArrayList<>();


    public Project addProject(ProjectDto projectDto){
        Project project = ProjectMapper.projectDtoToProject(projectDto);
        project.setId(projectDto.getId());
        project.setProjectTitle(projectDto.getProjectTitle());
        project.setAvailability(projectDto.getAvailability());
        projectsList.add(project);
        Logger.info("Project id {} saved", project.getId());
        return project;
    }

    public Project updateProject(int id, ProjectDto projectDto){
        Project project = ProjectMapper.projectDtoToProject(projectDto);
        project.setId(id);
        project.setProjectTitle(project.getProjectTitle());
        project.setAvailability(project.getAvailability());
        Logger.info("Project id {} updated", project.getId());
        return project;
    }

    public List<ProjectDto> getAllProjects(){
        return projectsList.stream()
                .map(ProjectMapper::projectToProjectDto)
                .collect(Collectors.toList());
    }
    
    public ProjectDto getProjectById(int id){
        ProjectDto projectDto = null;
        for(Project project: projectsList) {
            if (project.getId() == id) {
                projectDto = ProjectMapper.projectToProjectDto(project);
            }
        }
        if(projectDto == null){
            Logger.info("There is no project with given id.");
            throw new NoSuchProjectException("There is no project with given id.");
        }
        return projectDto;
    }

    public void writeJSON(Project project) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("projects.json"), project);
    }


}
