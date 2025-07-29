package com.medo.backend.question.repository;

import com.medo.backend.question.model.Answer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {
    // Add custom query methods if needed
} 