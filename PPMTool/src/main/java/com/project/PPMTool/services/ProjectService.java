package com.project.PPMTool.services;

import com.project.PPMTool.model.Project;
import com.project.PPMTool.repositories.ProjectRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
  @Autowired private ProjectRepository projectRepository;

  public Project saveOrUpdateProject(Project project) {
    // TODO: Logic
    return projectRepository.save(project);
  }

  public List<Project> getProjects() {
    return projectRepository.findAll();
  }
}
