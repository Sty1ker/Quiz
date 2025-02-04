package com.example.quiz.servis;

import com.example.quiz.domain.games.Games;
import com.example.quiz.web.dto.game.GameDto;
import java.util.List;


public interface GamesServis {

    public Games getById(Long id);

    // Получить список всех игр
    List<GameDto> getAllGames();

    // Создать новую игру
    GameDto createGame(GameDto gameDto);

    // Добавить игрока в игру
    boolean addPlayer(Long gameId);

    // Обновить статус игры
    boolean updateStatus(Long gameId);

}
