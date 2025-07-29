package com.medo.backend.user.controller;


import com.medo.backend.auth.dto.CreateUserDTO;
import com.medo.backend.user.dto.UserProfileDTO;
import com.medo.backend.user.dto.UserUpdateDTO;
import com.medo.backend.user.model.User;
import com.medo.backend.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController  {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/updateProfile/{id}")
    public UserProfileDTO updateUser(@RequestBody  UserUpdateDTO userUpdateDTO ,@PathVariable Long id) {
      userService.updateUser(userUpdateDTO);
        return null ;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable  Long id) {
        System.out.println(id);
    }

    @GetMapping("/display/{id}")
    public UserProfileDTO getUser(@PathVariable  Long id) {
        System.out.println(id);
        return new UserProfileDTO(2L,"test","hfh",null , null , null, 1, null, null);
    }
}
