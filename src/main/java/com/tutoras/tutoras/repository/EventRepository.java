package com.tutoras.tutoras.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutoras.tutoras.entity.EventEntity;

public interface EventRepository extends JpaRepository<EventEntity, Long>{}
