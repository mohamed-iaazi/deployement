package com.medo.backend.project.service.impl;

import com.medo.backend.project.dto.ProjectDTO;
import com.medo.backend.project.model.Project;
import com.medo.backend.project.repository.ProjectRepository;
import com.medo.backend.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public ProjectDTO createProject(ProjectDTO projectDTO) {
        Project project = Project.builder()
                .title(projectDTO.getTitle())
                .description(projectDTO.getDescription())
                .codeUrl(projectDTO.getCodeUrl())
                .demoUrl(projectDTO.getDemoUrl())
                .imageUrl(projectDTO.getImageUrl())
                .createdAt(projectDTO.getCreatedAt())
                .author(projectDTO.getAuthor())
                .build();
        Project saved = projectRepository.save(project);
        return toDTO(saved);
    }

    @Override
    public ProjectDTO updateProject(Long id, ProjectDTO projectDTO) {
        Optional<Project> optional = projectRepository.findById(id);
        if (optional.isEmpty()) return null;
        Project project = optional.get();
        project.setTitle(projectDTO.getTitle());
        project.setDescription(projectDTO.getDescription());
        project.setCodeUrl(projectDTO.getCodeUrl());
        project.setDemoUrl(projectDTO.getDemoUrl());
        project.setImageUrl(projectDTO.getImageUrl());
        Project updated = projectRepository.save(project);
        return toDTO(updated);
    }

    @Override
    public boolean deleteProject(Long id) {
        if (projectRepository.existsById(id)) {
            projectRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public ProjectDTO getProject(Long id) {
        return projectRepository.findById(id).map(this::toDTO).orElse(null);
    }

    @Override
    public List<ProjectDTO> getAllProjects() {
        return ((List<Project>) projectRepository.findAll())
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    private ProjectDTO toDTO(Project project) {
        return ProjectDTO.builder()
                .id(project.getId())
                .title(project.getTitle())
                .description(project.getDescription())
                .codeUrl(project.getCodeUrl())
                .demoUrl(project.getDemoUrl())
                .imageUrl(project.getImageUrl())
                .createdAt(project.getCreatedAt())
                .author(project.getAuthor())
                .likeCount(project.getLikes() != null ? project.getLikes().size() : 0)
                .build();
    }
} 