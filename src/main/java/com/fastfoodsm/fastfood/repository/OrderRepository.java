package com.fastfoodsm.fastfood.repository;

import com.fastfoodsm.fastfood.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
