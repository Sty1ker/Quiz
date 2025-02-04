package com.example.quiz.servis.impl;

import com.example.quiz.domain.Produckt.Produckt;
import com.example.quiz.servis.ProducktServis;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducktServisImpl implements ProducktServis {
    @Override
    public Produckt getById(Long id) {
        return null;
    }

    @Override
    public List<Produckt> getAll() {
        return List.of();
    }

    @Override
    public Produckt create(Produckt product) {
        return null;
    }

    @Override
    public Produckt update(Produckt product) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
