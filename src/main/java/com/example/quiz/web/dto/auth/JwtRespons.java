package com.example.quiz.web.dto.auth;

import lombok.Data;

@Data
public class JwtRespons {

    private Long id;
    private String username;
    private String accessToken;
    private String refreshToken;

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
