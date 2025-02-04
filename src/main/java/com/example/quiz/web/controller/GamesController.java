package com.example.quiz.web.controller;

import com.example.quiz.servis.GamesServis;
import com.example.quiz.web.dto.game.GameDto;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class GamesController {

    private final GamesServis gamesServis;

    @Autowired
    public GamesController(GamesServis gamesServis) {
        this.gamesServis = gamesServis;
    }

    // Получить список всех игр
    @GetMapping
    public ResponseEntity<List<GameDto>> getAllGames() {
        List<GameDto> games = gamesServis.getAllGames();
        return ResponseEntity.ok(games);
    }

    // Создать игру
    @PostMapping
    public ResponseEntity<GameDto> createGame(@Valid @RequestBody GameDto gameDto) {
        GameDto createdGame = gamesServis.createGame(gameDto);
        return ResponseEntity.ok(createdGame);
    }

    // Добавить игрока в игру
    @PostMapping("/{gameId}/addPlayer")
    public ResponseEntity<String> addPlayerToGame(@PathVariable Long gameId) {
        boolean success = gamesServis.addPlayer(gameId);
        if (success) {
            return ResponseEntity.ok("Игрок добавлен");
        } else {
            return ResponseEntity.badRequest().body("Мест нет");
        }
    }
}
