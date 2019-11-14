package com.fastfoodsm.fastfood.repository;

import com.fastfoodsm.fastfood.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
