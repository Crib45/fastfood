package com.fastfoodsm.fastfood.service;

import com.fastfoodsm.fastfood.model.Order;
import com.fastfoodsm.fastfood.model.customTypes.StatusType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderService {
    List<Order> getAllByIdUser(Long idUser);

    Order getById(Long id);

    String deleteById(Long id);

    String save(Order order);

    List<Order> getOrderByIdRestaurantAndStatus(Long idRestaurant, StatusType statusType);
}
