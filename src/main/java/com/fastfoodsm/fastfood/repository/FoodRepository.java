package com.fastfoodsm.fastfood.repository;

import com.fastfoodsm.fastfood.model.Category;
import com.fastfoodsm.fastfood.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    List<Food> findAllByCategoryId(Category category);
}
