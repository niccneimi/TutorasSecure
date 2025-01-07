package com.tutoras.tutoras.service;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tutoras.tutoras.entity.StudentEntity;
import com.tutoras.tutoras.entity.TeacherEntity;
import com.tutoras.tutoras.entity.UserEntity;
import com.tutoras.tutoras.model.ErrorResponse;
import com.tutoras.tutoras.model.RegistrationResponse;
import com.tutoras.tutoras.repository.StudentRepository;
import com.tutoras.tutoras.repository.TeacherRepository;
import com.tutoras.tutoras.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegistrationService {
    private final UserRepository userRepository;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public ResponseEntity<?> attemptRegistration(String email, String password, String role) {
        if (userRepository.findByEmail(email).isPresent()) {
            ErrorResponse errorResponse = new ErrorResponse(400L,"Пользователь с данной почтой уже существует");
            return ResponseEntity.status(400).body(errorResponse);
        }

        String encodedPassword = passwordEncoder.encode(password);
        UserEntity user = new UserEntity(email, encodedPassword, role);
        userRepository.save(user);

        if (role.equals("ROLE_TEACHER")) {
            TeacherEntity teacher = new TeacherEntity(user.getId(), user, new ArrayList<>());
            teacherRepository.save(teacher);
        } else if (role.equals("ROLE_STUDENT")) {
            StudentEntity student = new StudentEntity(user.getId(), user, new ArrayList<>());
            studentRepository.save(student);
        }
        
        return ResponseEntity.status(201).body(
            RegistrationResponse.builder()
            .text(user.getEmail())
            .build()
        );
    }
}
