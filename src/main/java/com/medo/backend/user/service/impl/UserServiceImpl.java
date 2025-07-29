package com.medo.backend.user.service.impl;

import com.medo.backend.auth.dto.CreateUserDTO;
import com.medo.backend.user.dto.UserProfileDTO;
import com.medo.backend.user.dto.UserUpdateDTO;
import com.medo.backend.user.model.User;
import com.medo.backend.user.repository.UserRepository;
import com.medo.backend.user.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserUpdateDTO updateUser(UserUpdateDTO userUpdateDTO) {

        User user = userRepository.findById(userUpdateDTO.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found  " ));

        assert user != null;
        user.setName(userUpdateDTO.getName());
        user.setEmail(userUpdateDTO.getEmail());
        user.setBio(userUpdateDTO.getBio());
        user.setAvatarUrl(userUpdateDTO.getAvatarUrl());
        user.setCompetences(userUpdateDTO.getCompetences());
        return  userUpdateDTO.userToDto(userRepository.save(user));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserProfileDTO getUser(Long id) {
        UserProfileDTO userProfileDTO = new UserProfileDTO();
        return userProfileDTO.toUserProfileDTO(userRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + id))
);
    }
}
