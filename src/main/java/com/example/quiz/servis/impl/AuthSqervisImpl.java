package com.example.quiz.servis.impl;

import com.example.quiz.domain.user.User;
import com.example.quiz.servis.AuthServis;
import com.example.quiz.servis.UserServis;
import com.example.quiz.web.dto.auth.JwtRequest;
import com.example.quiz.web.dto.auth.JwtRespons;
import com.example.quiz.web.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthSqervisImpl implements AuthServis {

    private final AuthenticationManager authenticationManager;
    private final UserServis userServis;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public JwtRespons login(JwtRequest loginRequest) {
        JwtRespons jwtRespons = new JwtRespons();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        User user = userServis.getByUsername(loginRequest.getUsername());
        jwtRespons.setId(user.getId());
        jwtRespons.setUsername(user.getUsername());
        jwtRespons.setAccessToken(jwtTokenProvider.createAccessToken(user.getId(), user.getUsername(), user.getRoles()));
        jwtRespons.setRefreshToken(jwtTokenProvider.createRefreshToken(user.getId(), user.getUsername()));
        return jwtRespons;
    }

    @Override
    public JwtRespons refresh(String refreshToken) {
        return jwtTokenProvider.refreshUserTokens(refreshToken);
    }
}
