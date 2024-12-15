package com.tutoras.tutoras.service;

import java.util.Optional;
import com.tutoras.tutoras.entity.UserEntity;
import com.tutoras.tutoras.repository.UserRepository;

import org.springframework.stereotype.Service;


@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<UserEntity> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
