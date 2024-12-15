package com.tutoras.tutoras.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tutoras.tutoras.entity.UserEntity;
import com.tutoras.tutoras.model.RegistrationResponse;
import com.tutoras.tutoras.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegistrationService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public RegistrationResponse attemptRegistration(String email, String password, String role) {
        if (userRepository.findByEmail(email).isPresent()) {
            return RegistrationResponse.builder()
                .text("User with this email already exists.")
                .build();
        }

        String encodedPassword = passwordEncoder.encode(password);
        UserEntity user = new UserEntity(email, encodedPassword, role, null);
        userRepository.save(user);
        return RegistrationResponse.builder()
            .text(user.getEmail())
            .build();
    }
}
