package com.fastfoodsm.fastfood.service;

import com.fastfoodsm.fastfood.model.Food;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FoodService {
    List<Food> getAll();
}
