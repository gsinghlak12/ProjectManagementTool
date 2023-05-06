package com.project.PPMTool.service;

import com.project.PPMTool.exception.BadRequestException;
import com.project.PPMTool.exception.NotFoundException;
import com.project.PPMTool.model.Project;
import com.project.PPMTool.repository.ProjectRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
  @Autowired private ProjectRepository projectRepository;
  private final String notFoundErrorMessage = "Project ID '${projectId}' not found.";

  public Project saveOrUpdateProject(Project project) {
    try {
      project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
      return projectRepository.save(project);
    } catch (Exception e) {
      String errorResponse =
          "Project ID '" + project.getProjectIdentifier().toUpperCase() + "' already exists.";
      throw new BadRequestException(errorResponse);
    }
  }

  public Project findByProjectIdentifier(String projectId) {
    Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
    if (project == null) {
      throw new NotFoundException(notFoundErrorMessage.replace("${projectId}", projectId));
    }
    return project;
  }

  public List<Project> getProjects() {
    return projectRepository.findAll();
  }

  public void deleteByProjectIdentifier(String projectId) {
    Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
    if (project == null) {
      throw new NotFoundException(notFoundErrorMessage.replace("${projectId}", projectId));
    }
    projectRepository.delete(project);
  }
}
