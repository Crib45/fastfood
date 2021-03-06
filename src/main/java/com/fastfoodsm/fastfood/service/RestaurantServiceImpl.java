package com.fastfoodsm.fastfood.service;

import com.fastfoodsm.fastfood.model.Restaurant;
import com.fastfoodsm.fastfood.model.User;
import com.fastfoodsm.fastfood.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService{
    @Autowired
    RestaurantRepository restaurantRepository;
    @Override
    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }

    @Override
    public String save(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
        return "Success";
    }
    @Override
    public String delete(Restaurant restaurant) {
        restaurantRepository.delete(restaurant);
        return "Success";
    }

    @Override
    public List<Restaurant> getByUser(User user) {
        return restaurantRepository.findAllByOwnerId(user);
    }

    @Override
    public Restaurant getByEmployee(User user) {
        return user.getEmployedAt();
    }

    @Override
    public Restaurant getById(Long id) {
        return restaurantRepository.findById(id).orElse(null);
    }
}
