package com.medo.backend.project.dto;

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
public class ProjectDTO {
    private Long id;
    private String title;
    private String description;
    private String codeUrl;
    private String demoUrl;
    private String imageUrl;
    private LocalDateTime createdAt;
    private User author;
    private List<ProjectCommentDTO> comments;
    private int likeCount;
} 