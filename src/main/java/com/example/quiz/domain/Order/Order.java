package com.example.quiz.domain.Order;

import com.example.quiz.domain.Produckt.Produckt;
import com.example.quiz.domain.rating.Rating;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "orderы")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    private Rating team;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Produckt product;

    private LocalDateTime orderTime; // Время заказа
}
