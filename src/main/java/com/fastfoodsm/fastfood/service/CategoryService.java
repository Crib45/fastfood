package com.fastfoodsm.fastfood.service;

import com.fastfoodsm.fastfood.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {
    List<Category> getAllByIdRestaurant(Long idRestaurant);
    Category getById(Long idCategory);
    String deleteById(Long idCategory);
    String save(Category category);
}
