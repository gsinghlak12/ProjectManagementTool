package com.project.PPMTool.controller;

import com.project.PPMTool.model.Project;
import com.project.PPMTool.service.MapValidationErrorService;
import com.project.PPMTool.service.ProjectService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

  @Autowired private ProjectService projectService;
  @Autowired private MapValidationErrorService mapValidationErrorService;

  @PostMapping
  public ResponseEntity<?> createNewProject(
      @Valid @RequestBody Project project, BindingResult result) {
    ResponseEntity<Map<String, String>> errorMap =
        mapValidationErrorService.validateProject(result);
    if (errorMap != null) {
      return errorMap;
    }
    projectService.saveOrUpdateProject(project);
    return new ResponseEntity<>(project, HttpStatus.CREATED);
  }

  @GetMapping("/{projectId}")
  public ResponseEntity<Project> getProjectById(@PathVariable String projectId) {
    Project project = projectService.findByProjectIdentifier(projectId);
    return new ResponseEntity<>(project, HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<List<Project>> getAllProjects() {
    List<Project> projects = projectService.getProjects();
    return new ResponseEntity<>(projects, HttpStatus.OK);
  }
}
