package com.tutoras.tutoras.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String email;

    @Column(nullable = true)
    private String firstName;
    @Column(nullable = true)
    private String lastName;

    @JsonIgnore
    private String password;

    private String role;

    @Column(nullable = true)
    private String extraInfo;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<EventEntity> events;

    @OneToMany(mappedBy = "folowed_user")
    @JsonIgnore
    private List<EventEntity> eventsAsFollower;

    private String avatar;

    @SuppressWarnings("unused")
    private UserEntity () {}

    public UserEntity(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public UserEntity(
        Long id, 
        String firstName, 
        String lastName, 
        String extraInfo, 
        String avatar, 
        String email, 
        String password, 
        String role, 
        List<EventEntity> events, 
        List<EventEntity> eventsAsFollower) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.extraInfo = extraInfo;
            this.avatar = avatar;
            this.email = email;
            this.password = password;
            this.role = role;
            this.events = events;
            this.eventsAsFollower = eventsAsFollower;
    }
}
