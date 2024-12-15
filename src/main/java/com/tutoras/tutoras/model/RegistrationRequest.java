package com.tutoras.tutoras.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RegistrationRequest {
    private String email;
    private String password;
    private String role;
}
