package com.example.quiz.domain.Produckt;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Produckt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name; // Название товара

    @Column(nullable = false)
    private double price; // Цена товара

    @Column(nullable = false)
    private int quantity;
}
