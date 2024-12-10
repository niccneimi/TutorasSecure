package com.tutoras.tutoras.service;

import java.util.Optional;
import com.tutoras.tutoras.entity.UserEntity;

import org.springframework.stereotype.Service;


@Service
public class UserService {

    private static final String EXISTING_EMAIL = "test@test.com";
    private static final String ANOTHER_EMAIL = "next@test.com";

    public Optional<UserEntity> findByEmail(String email) {        
        // TODO: Move this to a database
        if (EXISTING_EMAIL.equalsIgnoreCase(email)) {
            var user = new UserEntity();
            user.setId(1L);
            user.setEmail(EXISTING_EMAIL);
            user.setPassword("$2a$12$7TFK2iJUBirQT3fHz9/okuNpD4btJC3wL.l2klRPqcuhZrAH0LWu2"); //test
            user.setRole("ROLE_ADMIN");
            user.setExtraInfo("I'm admin");
            return Optional.of(user);
        } else if (ANOTHER_EMAIL.equalsIgnoreCase(email)) {
            var user = new UserEntity();
            user.setId(99L);
            user.setEmail(ANOTHER_EMAIL);
            user.setPassword("$2a$12$7TFK2iJUBirQT3fHz9/okuNpD4btJC3wL.l2klRPqcuhZrAH0LWu2"); //test
            user.setRole("ROLE_USER");
            user.setExtraInfo("I'm user");
            return Optional.of(user);
        }
        return Optional.empty();
    }

}
