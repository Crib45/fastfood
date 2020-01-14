package com.fastfoodsm.fastfood.controller;

import com.fastfoodsm.fastfood.model.Category;
import com.fastfoodsm.fastfood.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/category")
@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/getAllByIdRestaurant/{idRestaurant}")
    public ResponseEntity getAllByIdRestaurant(@PathVariable Long idRestaurant) {
        return ResponseEntity.ok(categoryService.getAllByIdRestaurant(idRestaurant));
    }

    @GetMapping("/{idCategory}")
    public ResponseEntity getById(@PathVariable Long idCategory) {
        return ResponseEntity.ok(categoryService.getById(idCategory));
    }

    @DeleteMapping("/{idCategory}")
    public ResponseEntity deleteById(@PathVariable Long idCategory){
        return ResponseEntity.ok(categoryService.deleteById(idCategory));
    }
}
