package com.example.quiz.repozitory;


import com.example.quiz.domain.Produckt.Produckt;

import java.util.List;
import java.util.Optional;

public interface ProducktReposit  {
    // Найти продукт по ID
    Optional<Produckt> findById(Long id);

    // Получить все продукты
    List<Produckt> findAll();

    // Сохранить продукт
    void save(Produckt product);

    // Обновить продукт
    void update(Produckt product);

    // Удалить продукт
    void deleteById(Long id);
}
