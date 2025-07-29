package com.medo.backend.user.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
public class Competence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long competenceId;
    private String name;
    @ManyToOne
    @JoinColumn(name = "user")
    @JsonIgnore
    private  User user;

}
