package com.fastfoodsm.fastfood.service;

import com.fastfoodsm.fastfood.model.Favorites;
import com.fastfoodsm.fastfood.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface FavoritesService {
    String save(Long idRestaurant, User user);
    ArrayList<Favorites> getAllByUser(User user);
    String delete(Long favoriteId);
}
