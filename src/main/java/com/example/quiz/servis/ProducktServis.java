package com.example.quiz.servis;

import com.example.quiz.domain.Produckt.Produckt;

import java.util.List;

public interface ProducktServis {

    // Получить продукт по ID
    Produckt getById(Long id);

    // Получить все продукты
    List<Produckt> getAll();

    // Создать продукт
    Produckt create(Produckt product);

    // Обновить продукт
    Produckt update(Produckt product);

    // Удалить продукт
    void deleteById(Long id);
}
