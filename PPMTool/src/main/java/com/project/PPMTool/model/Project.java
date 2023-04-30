package com.project.PPMTool.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.util.Date;
import javax.validation.constraints.*;

@Entity
public class Project {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Project name is required")
  private String projectName;

  @NotBlank(message = "Project Identifier is required")
  @Size(min = 4, max = 5, message = "Please use 4 to 5 characters")
  @Column(updatable = false, unique = true)
  private String projectIdentifier;

  @NotBlank(message = "Project description is required")
  private String description;

  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date end_date;

  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date created_At;

  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date modified_At;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  public String getProjectIdentifier() {
    return projectIdentifier;
  }

  public void setProjectIdentifier(String projectIdentifier) {
    this.projectIdentifier = projectIdentifier;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getEndDate() {
    return end_date;
  }

  public void setEndDate(Date endDate) {
    this.end_date = endDate;
  }

  public Date getCreated_At() {
    return created_At;
  }

  public void setCreated_At(Date created_At) {
    this.created_At = created_At;
  }

  public Date getModified_At() {
    return modified_At;
  }

  public void setModified_At(Date modified_At) {
    this.modified_At = modified_At;
  }

  @PrePersist
  protected void onCreate() {
    this.created_At = new Date();
  }

  @PreUpdate
  protected void onUpdate() {
    this.modified_At = new Date();
  }
}
