package com.fastfoodsm.fastfood.repository;

import com.fastfoodsm.fastfood.model.Favorites;
import com.fastfoodsm.fastfood.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface FavoritesRepository extends JpaRepository<Favorites, Long> {
    ArrayList<Favorites> findAllByUserId(User user);
}
