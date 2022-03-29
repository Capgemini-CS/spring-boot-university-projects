package com.example.springbootuniversityprojects.service;

import com.example.springbootuniversityprojects.domain.Project;
import com.example.springbootuniversityprojects.domain.dto.ProjectDto;
import com.example.springbootuniversityprojects.service.mapper.ProjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    public Project addProject(ProjectDto projectDto){
        Project project = ProjectMapper.projectDtoToProject(projectDto);
        project.setId(project.getId());
        project.setProjectTitle(project.getProjectTitle());
        project.setAvailability(project.getAvailability());
        return project;
    }


}
