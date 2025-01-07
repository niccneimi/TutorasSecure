package com.tutoras.tutoras.model;

import com.tutoras.tutoras.entity.UserEntity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponse {
    private UserEntity user;
}
