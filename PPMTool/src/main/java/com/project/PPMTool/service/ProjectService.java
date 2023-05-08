package com.project.PPMTool.service;

import com.project.PPMTool.exception.BadRequestException;
import com.project.PPMTool.exception.NotFoundException;
import com.project.PPMTool.model.Project;
import com.project.PPMTool.repository.ProjectRepository;
import jakarta.transaction.Transactional;
import java.time.DateTimeException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProjectService {
  @Autowired private ProjectRepository projectRepository;
  private final String notFoundErrorMessage = "Project ID '${projectId}' not found.";
  private final String badRequestErrorMessage = "Project ID '${projectId}' already exists.";

  public Project createProject(Project project) {
    try {
      project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
      return projectRepository.save(project);
    } catch (Exception e) {
      throw new BadRequestException(
          badRequestErrorMessage.replace(
              "${projectId}", project.getProjectIdentifier().toUpperCase()));
    }
  }

  public Project updateProjectById(String projectId, Project project) {
    try {
      Project existingProject = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
      if (project.getProjectName() != null && !project.getProjectName().isEmpty()) {
        existingProject.setProjectName(project.getProjectName());
      }
      if (project.getDescription() != null && !project.getDescription().isEmpty()) {
        existingProject.setDescription(project.getDescription());
      }
      if (project.getEnd_date() != null) {
        validateDate(project.getEnd_date().toString());
        existingProject.setEnd_date(project.getEnd_date());
      }
      return existingProject;
    } catch (Exception e) {
      throw new BadRequestException(e.getMessage());
    }
  }

  public Project findByProjectIdentifier(String projectId) {
    Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
    if (project == null) {
      throw new NotFoundException(
          notFoundErrorMessage.replace("${projectId}", projectId.toUpperCase()));
    }
    return project;
  }

  public List<Project> getProjects() {
    return projectRepository.findAll();
  }

  public void deleteByProjectIdentifier(String projectId) {
    Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
    if (project == null) {
      throw new NotFoundException(
          notFoundErrorMessage.replace("${projectId}", projectId.toUpperCase()));
    }
    projectRepository.delete(project);
  }

  private void validateDate(String dateStr) {
    try {
      DateTimeFormatter format =
          DateTimeFormatter.ofPattern("E MMM dd HH:mm:ss z uuuu").withLocale(Locale.ENGLISH);
      ZonedDateTime.parse(dateStr, format).toLocalDate();
    } catch (Exception e) {
      throw new DateTimeException("Date format must be 'yyyy-MM-dd'");
    }
  }
}
