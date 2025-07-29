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
public class UserProfileDTO {
    private Long userId;
    private String name;
    private String email;
    private String bio;
    private String avatarUrl;
    private List<Competence> competences;
    private int reputation;
    private  List<Badget> badgets;
    private String niveau;


    public  UserProfileDTO toUserProfileDTO(User user) {

        return  UserProfileDTO.builder()
                .name(user.getName())
                .email(user.getEmail())
                .bio(user.getBio())
                .avatarUrl(user.getAvatarUrl())
                .competences(user.getCompetences())
                .badgets(user.getBadgets())
                .niveau(user.getNiveau())
                .reputation(user.getReputation())
                .build();



    }
}
