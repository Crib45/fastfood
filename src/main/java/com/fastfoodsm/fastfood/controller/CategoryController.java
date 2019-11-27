package com.fastfoodsm.fastfood.controller;

import com.fastfoodsm.fastfood.model.Category;
import com.fastfoodsm.fastfood.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/category")
@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/{idRestaurant}")
    public ResponseEntity getAllByIdRestaurant(@PathVariable Long idRestaurant) {
        return ResponseEntity.ok(categoryService.getAllByIdRestaurant(idRestaurant));
    }
}
