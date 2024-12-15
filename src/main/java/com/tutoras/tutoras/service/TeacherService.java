package com.tutoras.tutoras.service;

import org.springframework.stereotype.Service;

import com.tutoras.tutoras.entity.StudentEntity;
import com.tutoras.tutoras.entity.TeacherEntity;
import com.tutoras.tutoras.model.TeacherResponse;
import com.tutoras.tutoras.repository.StudentRepository;
import com.tutoras.tutoras.repository.TeacherRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;

    public TeacherResponse getTeachersStudents(Long teacherId) {
        TeacherEntity teacher = teacherRepository.findById(teacherId).orElseThrow();
        return TeacherResponse.builder()
            .students(teacher.getStudents())
            .build();
    }

    public TeacherResponse addStudent(Long teacherId, Long studentId) {
        TeacherEntity teacher = teacherRepository.findById(teacherId).orElseThrow();
        StudentEntity newStudent = studentRepository.findById(studentId).orElseThrow();
        if (!teacher.getStudents().contains(newStudent)) {
            newStudent.getTeachers().add(teacher);
            teacher.getStudents().add(newStudent);
            teacherRepository.save(teacher);
            studentRepository.save(newStudent);
        }
        return TeacherResponse.builder()
            .students(teacher.getStudents())
            .build();
    }
}
