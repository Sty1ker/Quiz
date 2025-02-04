package com.example.quiz.web.dto.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtRequest {

    @NotBlank(message = "Username must be not null")
    private String username;

    @NotBlank(message = "Password must be not null")
    private String password;
}
