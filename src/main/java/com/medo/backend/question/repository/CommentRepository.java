package com.medo.backend.question.repository;

import com.medo.backend.question.model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
    // Add custom query methods if needed
} 