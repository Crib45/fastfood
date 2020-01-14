package com.fastfoodsm.fastfood.repository;

import com.fastfoodsm.fastfood.model.Order;
import com.fastfoodsm.fastfood.model.Restaurant;
import com.fastfoodsm.fastfood.model.User;
import com.fastfoodsm.fastfood.model.customTypes.StatusType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByUserId(User user);
    List<Order> findAllByRestaurantIdAndStatus(Restaurant restaurant, StatusType statusType);
}
