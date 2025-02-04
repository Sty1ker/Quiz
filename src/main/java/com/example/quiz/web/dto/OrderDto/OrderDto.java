package com.example.quiz.web.dto.OrderDto;

import com.example.quiz.web.dto.validation.OnCreate;
import com.example.quiz.web.dto.validation.OnUpdate;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class OrderDto {

    @NotBlank(groups = {OnCreate.class, OnUpdate.class}, message = "Название команды не может быть пустым")
    private String teamName;

    @NotBlank(groups = {OnCreate.class, OnUpdate.class}, message = "Название продукта не может быть пустым")
    private String productName;

    @NotNull(groups = OnCreate.class, message = "Время заказа обязательно при создании")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime orderTime;
}
