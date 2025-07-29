package com.medo.backend.project.model;

import com.medo.backend.user.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "project_like")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectLike {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Project project;
} 