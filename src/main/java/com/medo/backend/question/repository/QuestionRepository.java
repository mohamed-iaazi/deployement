package com.medo.backend.question.repository;

import com.medo.backend.question.model.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
    // Add custom query methods if needed
} 