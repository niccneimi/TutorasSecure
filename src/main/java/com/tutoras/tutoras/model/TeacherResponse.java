package com.tutoras.tutoras.model;

import java.util.List;
import com.tutoras.tutoras.entity.StudentEntity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TeacherResponse {
    private List<StudentEntity> students;
}
