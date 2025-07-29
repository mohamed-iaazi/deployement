package com.medo.backend.project.repository;

import com.medo.backend.project.model.ProjectLike;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectLikeRepository extends CrudRepository<ProjectLike, Long> {
    // Add custom query methods if needed
} 