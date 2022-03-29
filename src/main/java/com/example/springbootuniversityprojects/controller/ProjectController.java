package com.example.springbootuniversityprojects.controller;

import com.example.springbootuniversityprojects.domain.Project;
import com.example.springbootuniversityprojects.domain.dto.ProjectDto;
import com.example.springbootuniversityprojects.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/university")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @RequestMapping("/save-project")
    public ResponseEntity<Project> saveProject(@RequestParam ProjectDto projectDto){
        projectService.addProject(projectDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
