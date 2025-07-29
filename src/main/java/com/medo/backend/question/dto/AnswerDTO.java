package com.medo.backend.question.dto;

import com.medo.backend.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDTO {
    private Long id;
    private Long questionId;
    private User author;
    private String content;
    private LocalDateTime createdAt;
    private boolean isBestAnswer;
    private int voteCount;
} 