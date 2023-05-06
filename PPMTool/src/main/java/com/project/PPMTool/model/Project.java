package com.project.PPMTool.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.Date;
import lombok.Data;

@Entity
@Data
public class Project {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull(message = "Project name is required")
  private String projectName;

  @NotNull(message = "Project Identifier is required")
  @Column(updatable = false, unique = true)
  @Size(min = 4, max = 5, message = "Please use 4 to 5 characters")
  private String projectIdentifier;

  @NotNull(message = "Project description is required")
  private String description;

  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date end_date;

  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date created_At;

  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date modified_At;

  @PrePersist
  protected void onCreate() {
    this.created_At = new Date();
  }

  @PreUpdate
  protected void onUpdate() {
    this.modified_At = new Date();
  }
}
