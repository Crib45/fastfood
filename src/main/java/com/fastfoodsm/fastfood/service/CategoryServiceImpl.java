package com.fastfoodsm.fastfood.service;

import com.fastfoodsm.fastfood.model.Category;
import com.fastfoodsm.fastfood.model.Restaurant;
import com.fastfoodsm.fastfood.repository.CategoryRepository;
import com.fastfoodsm.fastfood.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    RestaurantRepository restaurantRepository;

    @Override
    public List<Category> getAllByIdRestaurant(Long idRestaurant) {
        Restaurant restaurant = restaurantRepository.findById(idRestaurant).get();
        return categoryRepository.findAllByRestaurantId(restaurant);
    }

    @Override
    public Category getById(Long idCategory) {
        return categoryRepository.findById(idCategory).orElse(null);
    }

    @Override
    public String deleteById(Long idCategory) {
        categoryRepository.deleteById(idCategory);
        return "Success";
    }

    @Override
    public String save(Category category) {
        categoryRepository.save(category);
        return "Success";
    }
}
