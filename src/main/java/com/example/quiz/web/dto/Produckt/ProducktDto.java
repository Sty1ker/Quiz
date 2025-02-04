package com.example.quiz.web.dto.Produckt;

import com.example.quiz.web.dto.validation.OnCreate;
import com.example.quiz.web.dto.validation.OnUpdate;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ProducktDto {

    @Null(groups = OnCreate.class, message = "ID должен быть пустым при создании")
    @NotNull(groups = OnUpdate.class, message = "ID обязателен при обновлении")
    private Long id;

    @NotBlank(groups = {OnCreate.class, OnUpdate.class}, message = "Название продукта не может быть пустым")
    @Size(min = 2, max = 100, groups = {OnCreate.class, OnUpdate.class}, message = "Название продукта должно содержать от 2 до 100 символов")
    private String name;

    @Positive(groups = {OnCreate.class, OnUpdate.class}, message = "Цена должна быть положительным числом")
    private double price;

    @NotBlank(groups = {OnCreate.class, OnUpdate.class}, message = "Количество не может быть пустым")
    @Pattern(regexp = "^[0-9]+$", groups = {OnCreate.class, OnUpdate.class}, message = "Количество должно быть числом")
    private int quantity;
}
