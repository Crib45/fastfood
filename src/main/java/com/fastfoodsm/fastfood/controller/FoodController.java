package com.fastfoodsm.fastfood.controller;

import com.fastfoodsm.fastfood.model.Food;
import com.fastfoodsm.fastfood.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/food")
@RestController
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping
    public Iterable<Food> findAll() {
        return foodService.getAll();
    }

}
