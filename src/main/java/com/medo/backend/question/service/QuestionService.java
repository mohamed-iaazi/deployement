package com.medo.backend.question.service;

import com.medo.backend.question.dto.QuestionDTO;
import java.util.List;

public interface QuestionService {
    QuestionDTO createQuestion(QuestionDTO questionDTO);
    QuestionDTO updateQuestion(Long id, QuestionDTO questionDTO);
    boolean deleteQuestion(Long id);
    QuestionDTO getQuestion(Long id);
    List<QuestionDTO> getAllQuestions();
} 