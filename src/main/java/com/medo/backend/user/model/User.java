package com.medo.backend.user.model;


import com.medo.backend.question.model.Question;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users") // Avoid reserved keyword
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Simple and conventional

    private String name;
    private String email;
    private String password;
    private String bio;
    private String avatarUrl;

    @OneToMany(mappedBy = "user")
    private List<Competence> competences;

    private int reputation;

    @OneToMany(mappedBy = "user")
    private List<Badget> badgets;

    private String niveau;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Question> questions = new ArrayList<>();
}
