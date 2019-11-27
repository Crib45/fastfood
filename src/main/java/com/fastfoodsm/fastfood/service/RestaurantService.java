package com.fastfoodsm.fastfood.service;

import com.fastfoodsm.fastfood.model.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> getAll();

    String save(Restaurant restaurant);

    String delete(Restaurant restaurant);
}
