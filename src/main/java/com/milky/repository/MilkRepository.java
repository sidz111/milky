package com.milky.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.milky.entity.Milk;

public interface MilkRepository extends JpaRepository<Milk, Integer> {
    // Custom Query (if needed) e.g., find by litre
    Milk findByLitre(Double litre);
}
