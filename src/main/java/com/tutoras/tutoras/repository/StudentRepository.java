package com.tutoras.tutoras.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutoras.tutoras.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Long>{}