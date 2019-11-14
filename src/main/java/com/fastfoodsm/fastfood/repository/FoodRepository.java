package com.fastfoodsm.fastfood.repository;

import com.fastfoodsm.fastfood.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
