package com.tutoras.tutoras.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "teachers")
public class TeacherEntity {

    @Id
    private Long teacherId;

    @ManyToMany(mappedBy = "teachers")
    @JsonManagedReference
    private List<StudentEntity> students = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @SuppressWarnings("unused")
    private TeacherEntity () {}

    public TeacherEntity (Long teacherId, UserEntity user) {
        this.teacherId = teacherId;
        this.user = user;
    }

}