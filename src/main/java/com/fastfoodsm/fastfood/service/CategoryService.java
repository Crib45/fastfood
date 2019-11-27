package com.fastfoodsm.fastfood.service;

import com.fastfoodsm.fastfood.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {
    List<Category> getAllByIdRestaurant(Long idRestaurant);
}
