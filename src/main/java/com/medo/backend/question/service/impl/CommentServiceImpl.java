package com.medo.backend.question.service.impl;

import com.medo.backend.question.dto.CommentDTO;
import com.medo.backend.question.model.Answer;
import com.medo.backend.question.model.Comment;
import com.medo.backend.question.model.Question;
import com.medo.backend.question.repository.AnswerRepository;
import com.medo.backend.question.repository.CommentRepository;
import com.medo.backend.question.repository.QuestionRepository;
import com.medo.backend.question.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, QuestionRepository questionRepository, AnswerRepository answerRepository) {
        this.commentRepository = commentRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    @Override
    public CommentDTO createComment(CommentDTO commentDTO) {
        Comment comment = Comment.builder()
                .content(commentDTO.getContent())
                .createdAt(commentDTO.getCreatedAt())
                .author(commentDTO.getAuthor())
                .build();
        if (commentDTO.getQuestionId() != null) {
            Optional<Question> q = questionRepository.findById(commentDTO.getQuestionId());
            q.ifPresent(comment::setQuestion);
        }
        if (commentDTO.getAnswerId() != null) {
            Optional<Answer> a = answerRepository.findById(commentDTO.getAnswerId());
            a.ifPresent(comment::setAnswer);
        }
        Comment saved = commentRepository.save(comment);
        return toDTO(saved);
    }

    @Override
    public boolean deleteComment(Long id) {
        if (commentRepository.existsById(id)) {
            commentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public CommentDTO getComment(Long id) {
        return commentRepository.findById(id).map(this::toDTO).orElse(null);
    }

    @Override
    public List<CommentDTO> getCommentsByQuestion(Long questionId) {
        return ((List<Comment>) commentRepository.findAll()).stream()
                .filter(c -> c.getQuestion() != null && c.getQuestion().getId().equals(questionId))
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CommentDTO> getCommentsByAnswer(Long answerId) {
        return ((List<Comment>) commentRepository.findAll()).stream()
                .filter(c -> c.getAnswer() != null && c.getAnswer().getId().equals(answerId))
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CommentDTO updateComment(Long id, CommentDTO commentDTO) {
        Optional<Comment> optional = commentRepository.findById(id);
        if (optional.isEmpty()) return null;
        Comment comment = optional.get();
        comment.setContent(commentDTO.getContent());
        // Optionally update author, question, answer if needed
        Comment updated = commentRepository.save(comment);
        return toDTO(updated);
    }

    private CommentDTO toDTO(Comment comment) {
        return CommentDTO.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .createdAt(comment.getCreatedAt())
                .author(comment.getAuthor())
                .questionId(comment.getQuestion() != null ? comment.getQuestion().getId() : null)
                .answerId(comment.getAnswer() != null ? comment.getAnswer().getId() : null)
                .build();
    }
} 