package com.medo.backend.user.service;


import com.medo.backend.user.dto.UserProfileDTO;
import com.medo.backend.user.dto.UserUpdateDTO;
import com.medo.backend.auth.dto.CreateUserDTO;


public interface UserService {

    // for crude simple for the users
    UserUpdateDTO updateUser(UserUpdateDTO userUpdateDTO);
    void deleteUser(Long id);
    UserProfileDTO getUser(Long id);


}
