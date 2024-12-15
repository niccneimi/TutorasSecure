package com.tutoras.tutoras.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "students")
public class StudentEntity {

    @Id
    private Long studentId;

    @ManyToMany
    @JoinTable(
        name = "student_teacher",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    @JsonBackReference
    private List<TeacherEntity> teachers = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @SuppressWarnings("unused")
    private StudentEntity () {}

    public StudentEntity (Long studentId, UserEntity user) {
        this.studentId = studentId;
        this.user = user;
    }
}
