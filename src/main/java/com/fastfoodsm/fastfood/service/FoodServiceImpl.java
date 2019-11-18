package com.fastfoodsm.fastfood.service;


import com.fastfoodsm.fastfood.model.Food;
import com.fastfoodsm.fastfood.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FoodServiceImpl  implements FoodService{

    @Autowired
    FoodRepository foodRepository;

    @Override
    public List<Food> getAll() {
        return foodRepository.findAll();
    }
}
