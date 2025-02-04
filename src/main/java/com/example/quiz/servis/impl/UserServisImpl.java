package com.example.quiz.servis.impl;

import com.example.quiz.domain.exception.ResoursNotFound;
import com.example.quiz.domain.user.User;
import com.example.quiz.repozitory.UserRepository;
import com.example.quiz.servis.UserServis;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServisImpl implements UserServis {

    private final UserRepository userRepository;

    @Override
    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResoursNotFound("User Not Found"));
    }

    @Override
    public User getByUsername(String userName) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public boolean isTaskOwner(Long userId, Long taskId) {
        return false;
    }

    @Override
    public User getTaskAuthor(Long taskId) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
