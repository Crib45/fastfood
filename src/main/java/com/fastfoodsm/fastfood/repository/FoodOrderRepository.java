package com.fastfoodsm.fastfood.repository;

import com.fastfoodsm.fastfood.model.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodOrderRepository extends JpaRepository<FoodOrder, Long> {
}
