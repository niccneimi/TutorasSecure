package com.tutoras.tutoras.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutoras.tutoras.entity.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, Long>{
    Optional<UserEntity> findByEmail(String email);
}
