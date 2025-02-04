package com.example.quiz.repozitory.impl;

import com.example.quiz.domain.Produckt.Produckt;
import com.example.quiz.repozitory.ProducktReposit;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProducktRepositoryImpl implements ProducktReposit {
    @Override
    public Optional<Produckt> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Produckt> findAll() {
        return List.of();
    }

    @Override
    public void save(Produckt product) {

    }

    @Override
    public void update(Produckt product) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
