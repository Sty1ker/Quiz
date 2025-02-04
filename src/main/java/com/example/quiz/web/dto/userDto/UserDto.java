package com.example.quiz.web.dto.userDto;

import com.example.quiz.domain.user.Role;
import com.example.quiz.web.dto.validation.OnCreate;
import com.example.quiz.web.dto.validation.OnUpdate;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

import java.util.Set;

public class UserDto {

    @Null(groups = OnCreate.class, message = "ID должен быть пустым при создании")
    @NotNull(groups = OnUpdate.class, message = "ID обязателен при обновлении")
    private Long id;

    @NotBlank(groups = {OnCreate.class, OnUpdate.class}, message = "Имя не может быть пустым")
    @Size(min = 2, max = 100, groups = {OnCreate.class, OnUpdate.class}, message = "Имя должно содержать от 2 до 100 символов")
    private String name;

    @NotBlank(groups = {OnCreate.class, OnUpdate.class}, message = "Имя пользователя не может быть пустым")
    @Size(min = 3, max = 50, groups = {OnCreate.class, OnUpdate.class}, message = "Имя пользователя должно содержать от 3 до 50 символов")
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // Пароль скрыт в ответе
    @NotBlank(groups = OnCreate.class, message = "Пароль не может быть пустым")
    @Size(min = 6, max = 100, groups = OnCreate.class, message = "Пароль должен содержать от 6 до 100 символов")
    private String password;

    @NotEmpty(groups = {OnCreate.class, OnUpdate.class}, message = "Пользователь должен иметь хотя бы одну роль")
    private Set<Role> roles;
}
