package com.example.quiz.repozitory;

import com.example.quiz.domain.user.Role;
import com.example.quiz.domain.user.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findById(Long id);
    Optional<User> findByUsername(String username);
    void insertUserRole(Long userId, Role role);
}
