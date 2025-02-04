package com.example.quiz.domain.rating;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ratings")
public class Rating {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                // Уникальный идентификатор команды

    @Column(nullable = false)
    private String teamName;        // Название команды

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TeamStatus status;      // Статус команды (новички, опытные, легенды)

    @Column(nullable = false)
    private int points;             // Количество очков команды

    // Метод для обновления статуса команды на основе очков
    public void updateStatus() {
        if (points < 100) {
            status = TeamStatus.BEGINNER; // Новички
        } else if (points < 500) {
            status = TeamStatus.EXPERIENCED; // Опытные
        } else {
            status = TeamStatus.LEGENDARY; // Легенды
        }
    }
}
