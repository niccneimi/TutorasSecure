package com.tutoras.tutoras.entity;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "events")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    private LocalDateTime date;

    private String description;

    private String name;

    private LocalDateTime date_created;

    private LocalDateTime update_at;

    @SuppressWarnings("unused")
    private EventEntity () {}

    public EventEntity(Long id, LocalDateTime date, LocalDateTime date_created, String name, UserEntity user, String description) {
        this.id = id;
        this.date = date;
        this.date_created = date_created;
        this.name = name;
        this.user = user;
        this.update_at = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);;
        this.description = description;
    }

    public EventEntity(LocalDateTime date, LocalDateTime date_created, String name, UserEntity user, String description) {
        this.date = date;
        this.date_created = date_created;
        this.name = name;
        this.user = user;
        this.update_at = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);;
        this.description = description;
    }
}
