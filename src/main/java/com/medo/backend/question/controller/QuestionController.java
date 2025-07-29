package com.medo.backend.question.controller;

import com.medo.backend.question.dto.QuestionDTO;
import com.medo.backend.question.service.QuestionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
@Tag(name = "Gestion De Questions",description = "Pour La gestion de Questions")
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }


    @Operation(description = "Cree Une Question")
    @PostMapping
    public ResponseEntity<QuestionDTO> createQuestion(@RequestBody QuestionDTO questionDTO) {
        return ResponseEntity.ok(questionService.createQuestion(questionDTO));
    }


    @Operation(description = "Modifier Une Question")
    @PutMapping("/{id}")
    public ResponseEntity<QuestionDTO> updateQuestion(@PathVariable Long id, @RequestBody QuestionDTO questionDTO) {
        return ResponseEntity.ok(questionService.updateQuestion(id, questionDTO));
    }


    @Operation(description = "Supprimer Une Question")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
        return ResponseEntity.noContent().build();
    }


    @Operation(description = "Afficher  Une  Question avec id")
    @GetMapping("/{id}")
    public ResponseEntity<QuestionDTO> getQuestion(@PathVariable Long id) {
        return ResponseEntity.ok(questionService.getQuestion(id));
    }


    @Operation(description = "Afficher  Tous les  Questions")
    @GetMapping
    public ResponseEntity<List<QuestionDTO>> getAllQuestions() {
        return ResponseEntity.ok(questionService.getAllQuestions());
    }
} 