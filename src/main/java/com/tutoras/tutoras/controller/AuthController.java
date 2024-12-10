package com.tutoras.tutoras.controller;

import org.springframework.web.bind.annotation.RestController;
import com.tutoras.tutoras.model.LoginRequest;
import com.tutoras.tutoras.model.LoginResponse;
import com.tutoras.tutoras.service.AuthService;

import lombok.RequiredArgsConstructor;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/auth/login")
    public LoginResponse login(@RequestBody @Validated LoginRequest request) {
        return authService.attemptLogin(request.getEmail(), request.getPassword());
    }
    
}
