package com.milky.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.milky.entity.DairyProduct;

@Repository
public interface DairyProductRepository extends JpaRepository<DairyProduct, Integer> {
	DairyProduct findByName(String name);
}
