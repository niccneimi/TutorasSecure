package com.tutoras.tutoras.service;

import java.util.Optional;
import com.tutoras.tutoras.entity.UserEntity;
import com.tutoras.tutoras.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<UserEntity> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
