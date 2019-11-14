package com.fastfoodsm.fastfood.repository;

import com.fastfoodsm.fastfood.model.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoritesRepository extends JpaRepository<Favorites, Long> {
}
