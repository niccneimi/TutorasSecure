package com.tutoras.tutoras.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    @SuppressWarnings("unused")
    private UserEntity () {}

    public UserEntity (String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
