package com.medo.backend.auth.dto;

import com.medo.backend.user.model.Competence;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDTO {
    private String name;
    private String email;
    private String password;
    private String bio;
    private String avatarUrl;
    private List<Competence> competences;

}
