package com.medo.backend.question.service;

import com.medo.backend.question.dto.CommentDTO;
import java.util.List;

public interface CommentService {
    CommentDTO createComment(CommentDTO commentDTO);
    boolean deleteComment(Long id);
    CommentDTO getComment(Long id);
    List<CommentDTO> getCommentsByQuestion(Long questionId);
    List<CommentDTO> getCommentsByAnswer(Long answerId);
    CommentDTO updateComment(Long id, CommentDTO commentDTO);
} 