package com.example.springbootuniversityprojects.controller;

import com.example.springbootuniversityprojects.domain.Project;
import com.example.springbootuniversityprojects.domain.dto.ProjectDto;
import com.example.springbootuniversityprojects.exception.JsonFormatException;
import com.example.springbootuniversityprojects.exception.NoSuchProjectException;
import com.example.springbootuniversityprojects.service.ProjectService;
import com.example.springbootuniversityprojects.service.util.UtilConvertor;
import com.example.springbootuniversityprojects.validation.NumberValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tinylog.Logger;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @Autowired
    NumberValidation numberValidation;

    @Autowired
    UtilConvertor utilConvertor;

    public ProjectController(ProjectService projectService, NumberValidation numberValidation, UtilConvertor utilConvertor){
        this.projectService = projectService;
        this.numberValidation = numberValidation;
        this.utilConvertor = utilConvertor;

    }

    @GetMapping("/all")
    public ResponseEntity<List<ProjectDto>> getAllProjects(){
       List<ProjectDto> projectsList = projectService.getAllProjects();
       return new ResponseEntity<>(projectsList, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Project> saveProject(@Valid @RequestBody ProjectDto projectDto) throws JsonFormatException {
        Project createdProject = projectService.addProject(projectDto);
        try {
            projectService.writeJSON(createdProject);
        } catch (IOException e) {
            Logger.error("Data couldn't be saved in JSON file.");
            throw new JsonFormatException("Data couldn't be saved in JSON file.");
        }
       return new ResponseEntity<>(createdProject, HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getProject(@RequestParam(value = "id") String id){
        ProjectDto projectDto;
        if(numberValidation.isNumeric(id)){
           projectDto = projectService.getProjectById(utilConvertor.stringToInt(id));
        } else {
            Logger.error("The value is not numeric.");
            throw new NumberFormatException("The value is not numeric.");
        }
        return new ResponseEntity<>(projectDto, HttpStatus.OK);

    }


    @PostMapping("/edit/{id}")
    public ResponseEntity<Project> updateProject(@RequestParam(value = "id")String id, @Valid @RequestBody ProjectDto projectDto){
        Project updatedProject;
        if(numberValidation.isNumeric(id)) {
               updatedProject = projectService.updateProject(utilConvertor.stringToInt(id), projectDto);
        } else{
            Logger.error("The value is not numeric.");
            throw new NumberFormatException("The value is not numeric.");
        }
        return new ResponseEntity<>(updatedProject, HttpStatus.OK);

    }

    @ExceptionHandler(JsonFormatException.class)
    public ResponseEntity<String> handleJsonFormatException(Exception exception){
        return new ResponseEntity<String>("Invalid Json format: " + exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NoSuchProjectException.class)
    public ResponseEntity<String> handleNotFound(Exception exception){
        return new ResponseEntity<String>("Project not found: " + exception.getMessage(), HttpStatus.NOT_FOUND);
    }


}
