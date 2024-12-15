package com.tutoras.tutoras.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutoras.tutoras.entity.TeacherEntity;

public interface TeacherRepository extends JpaRepository<TeacherEntity, Long>{}