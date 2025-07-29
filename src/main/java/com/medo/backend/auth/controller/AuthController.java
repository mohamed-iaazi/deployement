package com.medo.backend.auth.controller;


import com.medo.backend.auth.dto.AuthRequest;
import com.medo.backend.auth.dto.AuthResponse;
import com.medo.backend.auth.dto.CreateUserDTO;
import com.medo.backend.auth.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@Tag(name = "Authentication " , description = "Authentication api  ")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @Operation(description = "login api ")
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> auth(@RequestBody AuthRequest authRequest) {
        return authService.login(authRequest);
    }


    @Operation(description = "Register api ")
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> createAccount(@RequestBody  CreateUserDTO createUserDTO) {
    return authService.createAccount(createUserDTO);
    }

}
