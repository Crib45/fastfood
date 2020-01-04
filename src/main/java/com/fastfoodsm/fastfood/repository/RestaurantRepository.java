package com.fastfoodsm.fastfood.repository;

import com.fastfoodsm.fastfood.model.Restaurant;
import com.fastfoodsm.fastfood.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    ArrayList<Restaurant> findAllByOwnerId(User user);
}
