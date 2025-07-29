package com.medo.backend.auth.service;

import com.medo.backend.auth.dto.AuthRequest;
import com.medo.backend.auth.dto.AuthResponse;
import com.medo.backend.auth.dto.CreateUserDTO;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    public ResponseEntity<AuthResponse> createAccount(CreateUserDTO userDTO);
    public ResponseEntity<AuthResponse>  login(AuthRequest authRequest);

}
