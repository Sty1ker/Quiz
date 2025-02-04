package com.example.quiz.servis.impl;

import com.example.quiz.domain.exception.ResoursNotFound;
import com.example.quiz.domain.games.GameStatus;
import com.example.quiz.domain.games.Games;
import com.example.quiz.repozitory.GamesRepository;
import com.example.quiz.servis.GamesServis;
import com.example.quiz.web.dto.game.GameDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
public class GamesServisImpl implements GamesServis {

    private final GamesRepository gamesRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public GamesServisImpl(GamesRepository gamesRepository, ModelMapper modelMapper) {
        this.gamesRepository = gamesRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Games getById(Long id) {
        return gamesRepository.findById(id)
                .orElseThrow(() -> new ResoursNotFound("Game Not Found"));
    }

    // Получить список всех игр
    @Override
    @Transactional(readOnly = true)
    public List<GameDto> getAllGames() {
        List<Games> games = gamesRepository.findAll(); // Получаем все игры из базы данных
        return games.stream()
                .map(game -> modelMapper.map(game, GameDto.class)) // Преобразуем каждую сущность в DTO
                .collect(Collectors.toList()); // Собираем все DTO в список
    }

    // Создать новую игру
    @Override
    @Transactional
    public GameDto createGame(GameDto gameDto) {
        Games game = modelMapper.map(gameDto, Games.class); // Преобразуем DTO в сущность
        game.setCurrentPlayers(0); // Начинаем с 0 игроков
        game.setStatus(GameStatus.AVAILABLE); // Устанавливаем статус игры как доступную
        Games savedGame = gamesRepository.save(game); // Сохраняем игру
        return modelMapper.map(savedGame, GameDto.class); // Возвращаем DTO созданной игры
    }

    // Добавить игрока в игру
    @Override
    @Transactional
    public boolean addPlayer(Long gameId) {
        Games game = gamesRepository.findById(gameId).orElse(null); // Получаем игру по ID
        if (game == null || game.getStatus() == GameStatus.FULL) {
            return false; // Если игры нет или она уже полная
        }

        boolean added = game.addPlayer(); // Пробуем добавить игрока
        if (added) {
            gamesRepository.save(game); // Сохраняем изменения в игре
        }
        return added;
    }

    // Обновить статус игры
    @Override
    @Transactional
    public boolean updateStatus(Long gameId) {
        Games game = gamesRepository.findById(gameId).orElse(null);
        if (game == null) {
            return false; // Если игры не существует
        }

        game.updateStatus(); // Обновляем статус игры в зависимости от игроков
        gamesRepository.save(game); // Сохраняем обновленную игру
        return true;
    }
}
