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
public class CommentDTO {
    private Long id;
    private String content;
    private LocalDateTime createdAt;
    private User author;
    private Long questionId;
    private Long answerId;
    private int likeCount;
} 