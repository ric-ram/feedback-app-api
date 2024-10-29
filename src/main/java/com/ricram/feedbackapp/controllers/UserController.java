package com.ricram.feedbackapp.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.ricram.feedbackapp.dtos.UserResponse;
import com.ricram.feedbackapp.entity.User;
import com.ricram.feedbackapp.jwt.JwtService;
import com.ricram.feedbackapp.service.UserService;
import com.ricram.feedbackapp.views.Views;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final JwtService jwtService;
    private final UserService userService;

    @JsonView(Views.Public.class)
    @GetMapping
    public ResponseEntity<UserResponse> getUser(HttpServletRequest request) {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String token;
        final String userEmail;

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.ok(UserResponse.builder().build());
        }

        token = authHeader.substring(7);
        userEmail = jwtService.extractUsername(token);
        if (userEmail != null) {
            var user = userService.getUserByEmail(userEmail);

            if (jwtService.isTokenValid(token, user)) {
                return ResponseEntity.ok(UserResponse.builder()
                        .user(user)
                        .build());
            }
        }

        return ResponseEntity.ok(UserResponse.builder().build());
    }

}
