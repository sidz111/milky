package com.milky.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.milky.entity.Order;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    // Find Orders by User
    List<Order> findByUserId(Integer userId);

    // Find Orders by Confirmation Status
    List<Order> findByIsConfirmed(Boolean isConfirmed);
}
