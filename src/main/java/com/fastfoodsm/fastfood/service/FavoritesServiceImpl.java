package com.fastfoodsm.fastfood.service;

import com.fastfoodsm.fastfood.model.Favorites;
import com.fastfoodsm.fastfood.model.Restaurant;
import com.fastfoodsm.fastfood.model.User;
import com.fastfoodsm.fastfood.repository.FavoritesRepository;
import com.fastfoodsm.fastfood.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class FavoritesServiceImpl implements FavoritesService {
    @Autowired
    FavoritesRepository favoritesRepository;
    @Autowired
    RestaurantRepository restaurantRepository;


    @Override
    public String save(Long idRestaurant, User user) {
        Restaurant restaurant = restaurantRepository.findById(idRestaurant).orElse(null);
        Favorites favorites = new Favorites();
        favorites.setRestaurantId(restaurant);
        favorites.setUserId(user);
        favoritesRepository.save(favorites);
        return "Success";
    }

    @Override
    public ArrayList<Favorites> getAllByUser(User user) {

        return favoritesRepository.findAllByUserId(user);
    }

    @Override
    public String delete(Long favoriteId) {
        favoritesRepository.delete(Objects.requireNonNull(favoritesRepository.findById(favoriteId)
                .orElse(null)));
        return "Success";
    }
}
