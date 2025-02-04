package com.example.quiz.servis;

import com.example.quiz.domain.user.User;

public interface  UserServis {

    User getById(
            Long id
    );

    User getByUsername(
            String username
    );

    User update(
            User user
    );

    User create(
            User user
    );

    boolean isTaskOwner(
            Long userId,
            Long taskId
    );

    User getTaskAuthor(
            Long taskId
    );

    void delete(
            Long id
    );
}
