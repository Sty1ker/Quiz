package com.example.quiz.repozitory;

import com.example.quiz.domain.Order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    // Метод для получения всех заказов определенной команды
    List<Order> findByTeamId(Long teamId);
}
