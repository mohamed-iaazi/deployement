package com.medo.backend.question.controller;

import com.medo.backend.question.dto.CommentDTO;
import com.medo.backend.question.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<CommentDTO> createComment(@RequestBody CommentDTO commentDTO) {
        return ResponseEntity.ok(commentService.createComment(commentDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentDTO> getComment(@PathVariable Long id) {
        return ResponseEntity.ok(commentService.getComment(id));
    }

    @GetMapping("/question/{questionId}")
    public ResponseEntity<List<CommentDTO>> getCommentsByQuestion(@PathVariable Long questionId) {
        return ResponseEntity.ok(commentService.getCommentsByQuestion(questionId));
    }

    @GetMapping("/answer/{answerId}")
    public ResponseEntity<List<CommentDTO>> getCommentsByAnswer(@PathVariable Long answerId) {
        return ResponseEntity.ok(commentService.getCommentsByAnswer(answerId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentDTO> updateComment(@PathVariable Long id, @RequestBody CommentDTO commentDTO) {
        return ResponseEntity.ok(commentService.updateComment(id, commentDTO));
    }
} 