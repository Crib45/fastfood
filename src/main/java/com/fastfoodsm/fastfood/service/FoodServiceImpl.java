package com.fastfoodsm.fastfood.service;


import com.fastfoodsm.fastfood.model.Category;
import com.fastfoodsm.fastfood.model.Food;
import com.fastfoodsm.fastfood.repository.CategoryRepository;
import com.fastfoodsm.fastfood.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    FoodRepository foodRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Food> getAll() {
        return foodRepository.findAll();
    }

    @Override
    public Food getById(Long id) {
        return foodRepository.findById(id).get();
    }

    @Override
    public List<Food> getAllByCategory(Long idCategory) {
        Category category = categoryRepository.findById(idCategory).get();
        return foodRepository.findAllByCategoryId(category);
    }

    @Override
    public String save(Food food) {
        foodRepository.save(food);
        return "Success";
    }

    @Override
    public String delete(Long id) {
        Food food = foodRepository.findById(id).get();
        foodRepository.delete(food);
        return "Success";
    }
}
