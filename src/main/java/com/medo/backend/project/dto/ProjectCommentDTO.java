package com.medo.backend.project.dto;

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
public class ProjectCommentDTO {
    private Long id;
    private String content;
    private LocalDateTime createdAt;
    private User author;
    private Long projectId;
} 