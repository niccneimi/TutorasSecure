package com.tutoras.tutoras.service;

import java.util.Optional;
import com.tutoras.tutoras.entity.UserEntity;
import com.tutoras.tutoras.model.UserResponse;
import com.tutoras.tutoras.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<UserEntity> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public ResponseEntity<?> getProfile(String email) {
        UserEntity profile = userRepository.findByEmail(email).orElseThrow();
        return ResponseEntity.status(200).body(UserResponse.builder()
            .user(profile)
            .build());
    }

}
