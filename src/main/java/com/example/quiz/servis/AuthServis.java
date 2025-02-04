package com.example.quiz.servis;

import com.example.quiz.web.dto.auth.JwtRequest;
import com.example.quiz.web.dto.auth.JwtRespons;

public interface AuthServis {

    JwtRespons login(JwtRequest loginRequest);

    JwtRespons refresh(String refreshToken);

}
