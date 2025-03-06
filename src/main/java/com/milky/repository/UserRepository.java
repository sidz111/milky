package com.milky.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.milky.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    // Custom Query (if needed) e.g., find by name
    User findByName(String name);
}
