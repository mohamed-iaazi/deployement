package com.medo.backend.project.repository;

import com.medo.backend.project.model.ProjectComment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectCommentRepository extends CrudRepository<ProjectComment, Long> {
    // Add custom query methods if needed
} 