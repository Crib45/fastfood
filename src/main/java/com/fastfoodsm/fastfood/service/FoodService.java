package com.fastfoodsm.fastfood.service;

import com.fastfoodsm.fastfood.model.Food;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FoodService {
    List<Food> getAll();
    Food getById(Long id);
    List<Food> getAllByCategory(Long idCategory);
    String save(Food food);
    String delete(Long id);
}
