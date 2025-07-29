package com.medo.backend.user.dto;

import com.medo.backend.user.model.Badget;
import com.medo.backend.user.model.Competence;
import com.medo.backend.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateDTO {
    private Long userId;
    private String name;
    private String email;
    private String password;
    private String bio;
    private String avatarUrl;
    private List<Competence> competences;

    public UserUpdateDTO userToDto(User user) {

        return UserUpdateDTO.builder()
                .userId(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .bio(user.getBio())
                .avatarUrl(user.getAvatarUrl())
                .competences(user.getCompetences())
                .password(user.getPassword())
                .build();

    }
}
