package com.medo.backend.question.model;

import com.medo.backend.user.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;
    private String content;
    private LocalDateTime createdAt;
    private boolean isBestAnswer;
}