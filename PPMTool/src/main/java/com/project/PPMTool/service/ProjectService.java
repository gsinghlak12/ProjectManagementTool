package com.project.PPMTool.service;

import com.project.PPMTool.exception.ProjectIdException;
import com.project.PPMTool.model.Project;
import com.project.PPMTool.repository.ProjectRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
  @Autowired private ProjectRepository projectRepository;

  public Project saveOrUpdateProject(Project project) {
    try {
      project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
      return projectRepository.save(project);
    } catch (Exception e) {
      throw new ProjectIdException(
          "Project ID '" + project.getProjectIdentifier().toUpperCase() + "' already exists.");
    }
  }

  public List<Project> getProjects() {
    return projectRepository.findAll();
  }
}
