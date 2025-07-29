package com.medo.backend.user.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Badget {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long budgetId;
    private  String title;
    @ManyToOne
    @JoinColumn(name = "user")
    private User user;
}
