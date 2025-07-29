package com.medo.backend.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectLikeDTO {
    private Long id;
    private Long userId;
    private Long projectId;
} 