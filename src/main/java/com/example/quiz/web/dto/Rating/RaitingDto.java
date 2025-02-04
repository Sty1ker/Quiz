package com.example.quiz.web.dto.Rating;

import com.example.quiz.domain.rating.TeamStatus;
import com.example.quiz.web.dto.validation.OnCreate;
import com.example.quiz.web.dto.validation.OnUpdate;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class RaitingDto {

    @Null(groups = OnCreate.class, message = "ID должен быть пустым при создании")
    @NotNull(groups = OnUpdate.class, message = "ID обязателен при обновлении")
    private Long id;

    @NotBlank(groups = {OnCreate.class, OnUpdate.class}, message = "Название команды не может быть пустым")
    @Size(min = 2, max = 100, groups = {OnCreate.class, OnUpdate.class}, message = "Название команды должно содержать от 2 до 100 символов")
    private String teamName;

    @NotNull(groups = {OnCreate.class, OnUpdate.class}, message = "Статус команды обязателен")
    private TeamStatus status;

    @Min(value = 0, groups = {OnCreate.class, OnUpdate.class}, message = "Очки не могут быть отрицательными")
    private int points;

}
