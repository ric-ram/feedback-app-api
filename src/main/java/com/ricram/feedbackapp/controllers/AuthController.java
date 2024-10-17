package com.ricram.feedbackapp.controllers;

import com.ricram.feedbackapp.dtos.AuthenticationResponse;
import com.ricram.feedbackapp.dtos.LoginUserDto;
import com.ricram.feedbackapp.dtos.RegisterUserDto;
import com.ricram.feedbackapp.service.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> registerUser(@RequestBody RegisterUserDto registerUserDto) {
        return ResponseEntity.ok(authService.register(registerUserDto));
    }


    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticateUser(@RequestBody LoginUserDto loginUserDto) {
        return ResponseEntity.ok(authService.authenticate(loginUserDto));
    }

    @PostMapping("/refresh-token")
    public void refreshToken (HttpServletRequest request, HttpServletResponse response) throws IOException {
        authService.refreshToken(request, response);
    }
}

