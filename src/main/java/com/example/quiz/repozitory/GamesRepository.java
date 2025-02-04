package com.example.quiz.repozitory;

import com.example.quiz.domain.games.Games;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.quiz.domain.games.GameStatus;

import java.util.List;

@Repository
public interface GamesRepository extends JpaRepository<Games, Long> {

    List<Games> findByStatus(GameStatus status);
}
