package com.project.PPMTool.controllers;

import com.project.PPMTool.model.Project;
import com.project.PPMTool.services.ProjectService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

  @Autowired private ProjectService projectService;

  @PostMapping
  public ResponseEntity<Project> createNewProject(@RequestBody Project project) {
    projectService.saveOrUpdateProject(project);
    return new ResponseEntity<>(project, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<Project>> getProjects() {
    List<Project> projects = projectService.getProjects();
    return new ResponseEntity<>(projects, HttpStatus.OK);
  }
}
