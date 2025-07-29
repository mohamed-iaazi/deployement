package com.medo.backend.question.dto;

import com.medo.backend.question.model.Answer;
import com.medo.backend.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private AuthorDTO author;
}