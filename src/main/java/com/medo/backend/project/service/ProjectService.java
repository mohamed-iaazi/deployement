package com.medo.backend.project.service;

import com.medo.backend.project.dto.ProjectDTO;
import java.util.List;

public interface ProjectService {
    ProjectDTO createProject(ProjectDTO projectDTO);
    ProjectDTO updateProject(Long id, ProjectDTO projectDTO);
    boolean deleteProject(Long id);
    ProjectDTO getProject(Long id);
    List<ProjectDTO> getAllProjects();
} 