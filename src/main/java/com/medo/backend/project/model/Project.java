package com.medo.backend.project.model;

import com.medo.backend.user.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private String codeUrl;
    private String demoUrl;
    private String imageUrl;
    private LocalDateTime createdAt;
    @ManyToOne
    private User author;
    @OneToMany(mappedBy = "project")
    private List<ProjectComment> comments;
    @OneToMany(mappedBy = "project")
    private List<ProjectLike> likes;
} 