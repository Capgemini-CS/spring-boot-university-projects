package com.example.springbootuniversityprojects.controller;

import com.example.springbootuniversityprojects.domain.Project;
import com.example.springbootuniversityprojects.domain.dto.ProjectDto;
import com.example.springbootuniversityprojects.exception.JsonFormatException;
import com.example.springbootuniversityprojects.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tinylog.Logger;

import java.io.IOException;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    public ProjectController(ProjectService projectService){
        this.projectService = projectService;

    }


    @PostMapping("/save")
    @ExceptionHandler(JsonFormatException.class)
    public ResponseEntity<Project> saveProject(@RequestBody ProjectDto projectDto) throws JsonFormatException {
        Project createdProject = projectService.addProject(projectDto);
        try {
            projectService.writeJSON(createdProject);
        } catch (IOException e) {
            Logger.error("Data couldn't be saved in JSON file.");
            throw new JsonFormatException("Data couldn't be saved in JSON file.");
        }
       return new ResponseEntity<>(createdProject, HttpStatus.CREATED);

    }

//    @GetMapping("/{id}")
//    public ResponseEntity<ProjectDto> getProject(@PathVariable("id") int id){
//
//    }



}
