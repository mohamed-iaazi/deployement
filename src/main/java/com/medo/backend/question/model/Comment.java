package com.medo.backend.question.model;

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
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String content;
    private LocalDateTime createdAt;
    @ManyToOne
    private User author;
    @ManyToOne
    private Question question;
    @ManyToOne
    private Answer answer;
}