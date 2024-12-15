package com.tutoras.tutoras.controller;

import org.springframework.web.bind.annotation.RestController;

import com.tutoras.tutoras.model.TeacherRequest;
import com.tutoras.tutoras.model.TeacherResponse;
import com.tutoras.tutoras.security.UserPrincipal;
import com.tutoras.tutoras.service.TeacherService;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/teacher/students")
    public TeacherResponse getTeachersStudents(@AuthenticationPrincipal UserPrincipal principal) {
        return teacherService.getTeachersStudents(principal.getUserId());
    }

    @PostMapping("/teacher/add/student")
    public TeacherResponse addStudent(@AuthenticationPrincipal UserPrincipal principal, @RequestBody @Validated TeacherRequest request) {        
        return teacherService.addStudent(principal.getUserId(),request.getStudentId());
    }
    
    
}
