package com.ricram.feedbackapp.service;

import com.ricram.feedbackapp.dao.UserRepository;
import com.ricram.feedbackapp.dtos.UserResponse;
import com.ricram.feedbackapp.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService  {

    private final UserRepository userRepository;

    public User getUserByEmail(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow();
    }
}
