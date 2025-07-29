package com.medo.backend.project.repository;

import com.medo.backend.project.model.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
    // Add custom query methods if needed
} 