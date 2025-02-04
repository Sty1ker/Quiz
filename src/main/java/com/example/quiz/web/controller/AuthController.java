package com.example.quiz.web.controller;


import com.example.quiz.domain.user.User;
import com.example.quiz.servis.AuthServis;
import com.example.quiz.servis.UserServis;
import com.example.quiz.web.dto.auth.JwtRequest;
import com.example.quiz.web.dto.auth.JwtRespons;
import com.example.quiz.web.dto.userDto.UserDto;
import com.example.quiz.web.dto.validation.OnCreate;
import com.example.quiz.web.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Validated
public class AuthController {

    private final AuthServis authServis;
    private final UserServis userServis;
    private final UserMapper userMapper;

    @PostMapping
    public JwtRespons login(@Validated @RequestBody JwtRequest jwtRequest) {
        return authServis.login(jwtRequest);
    }

    @PostMapping("/register")
    public UserDto register(@Validated (OnCreate.class) @RequestBody UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        User createdUser = userServis.create(user);
        return userMapper.toDto(createdUser);
    }

    @PostMapping("/refresh")
    public JwtRespons refresh(@RequestBody String refreshToken){
        return authServis.refresh(refreshToken);
    }

}
