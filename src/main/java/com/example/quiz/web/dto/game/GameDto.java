package com.example.quiz.web.dto.game;

import com.example.quiz.domain.games.GameStatus;
import com.example.quiz.web.dto.validation.OnCreate;
import com.example.quiz.web.dto.validation.OnUpdate;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class GameDto {

    @Null(groups = OnCreate.class, message = "ID должен быть пустым при создании")
    @NotNull(groups = OnUpdate.class, message = "ID обязателен при обновлении")
    private Long id;                   // Уникальный идентификатор игры

    @NotBlank(groups = {OnCreate.class, OnUpdate.class}, message = "Название игры не может быть пустым")
    @Size(min = 3, max = 100, groups = {OnCreate.class, OnUpdate.class}, message = "Название должно содержать от 3 до 100 символов")
    private String title;              // Название игры

    @NotBlank(groups = {OnCreate.class, OnUpdate.class}, message = "Место игры не может быть пустым")
    @Size(min = 5, max = 255, groups = {OnCreate.class, OnUpdate.class}, message = "Описание места должно содержать от 5 до 255 символов")
    private String place;              // место игры или ее описание

    @Min(value = 1, groups = {OnCreate.class, OnUpdate.class}, message = "Номер игры должен быть положительным числом")
    private int numberOfGames;         // номер игры

    @Positive(groups = {OnCreate.class, OnUpdate.class}, message = "Цена за участие должна быть положительной")
    private int price;                 // Цена за участие

    @Min(value = 1, groups = {OnCreate.class, OnUpdate.class}, message = "Лимит игроков должен быть минимум 1")
    private int countOfPlayers;        // Лимит количества игроков

    @Min(value = 0, groups = {OnUpdate.class}, message = "Текущее количество игроков не может быть отрицательным")
    private int currentPlayers = 0;        // Текущее количество зарегистрированных игроков

    @NotNull(groups = {OnCreate.class, OnUpdate.class}, message = "Дата игры не может быть пустой")
    @FutureOrPresent(groups = {OnCreate.class, OnUpdate.class}, message = "Дата игры не может быть в прошлом")
    private LocalDate gameDate;        // Дата игры

    @NotNull(groups = {OnCreate.class, OnUpdate.class}, message = "Статус игры не может быть пустым")
    private GameStatus status;
}
