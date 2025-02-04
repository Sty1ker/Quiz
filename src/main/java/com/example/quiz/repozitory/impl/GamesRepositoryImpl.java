package com.example.quiz.repozitory.impl;

import com.example.quiz.domain.games.GameStatus;
import com.example.quiz.domain.games.Games;
import com.example.quiz.repozitory.GamesRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public class GamesRepositoryImpl implements GamesRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public <S extends Games> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public List<Games> findAll(){
        return entityManager.createQuery("SELECT g FROM Games g", Games.class).getResultList();
    }

    @Override
    public List<Games> findAllById(Iterable<Long> longs) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public Optional<Games> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Games.class, id));
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    @Transactional
    public Games save(Games game) {
        if (game.getId() == null) {
            entityManager.persist(game);
            return game;
        } else {
            return entityManager.merge(game);
        }
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Games games = entityManager.find(Games.class, id);
        if (games != null) {
            entityManager.remove(games);
        }
    }

    @Override
    public void delete(Games entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Games> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Games> findByStatus(GameStatus status) {
        return entityManager.createQuery(
                "SELECT g FROM Games g WHERE g.status = :status", Games.class)
                .setParameter("status", status)
                .getResultList();
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Games> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Games> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Games> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Games getOne(Long aLong) {
        return null;
    }

    @Override
    public Games getById(Long aLong) {
        return null;
    }

    @Override
    public Games getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Games> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Games> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Games> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Games> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Games> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Games> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Games, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public List<Games> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Games> findAll(Pageable pageable) {
        return null;
    }
}
