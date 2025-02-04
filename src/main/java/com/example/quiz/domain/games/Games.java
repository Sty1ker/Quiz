package com.example.quiz.domain.games;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "games")
public class Games {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    private String place;
    private int numberOfGames;         // номер игры
    private int price;                 // Цена за участие
    private int countOfPlayers;        // Лимит количества игроков
    private int currentPlayers = 0;        // Текущее количество зарегистрированных игроков
    private LocalDate gameDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GameStatus status;

    // Метод для добавления игрока
    public boolean addPlayer() {
        if (currentPlayers < countOfPlayers) {
            currentPlayers++;
            updateStatus();
            return true;
        } else {
            updateStatus();
            return false;
        }
    }

    // Метод для обновления статуса игры
    public void updateStatus() {
        if (currentPlayers >= countOfPlayers) {
            status = GameStatus.FULL;
        } else {
            status = GameStatus.AVAILABLE;
        }
    }

    public Long getId(){
        return id;
    }

    public GameStatus getStatus(){
        return status;
    }

    public void setStatus(GameStatus status){
        this.status = status;
    }

    public void setCurrentPlayers(int currentPlayers){
        this.currentPlayers = currentPlayers;
        updateStatus();
    }

    public void updateCurrentPlayers(){
        if (currentPlayers >= countOfPlayers) {
            status = GameStatus.FULL;
        } else {
            status = GameStatus.AVAILABLE;
        }
    }
}
