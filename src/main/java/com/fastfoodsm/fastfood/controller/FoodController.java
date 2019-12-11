package com.fastfoodsm.fastfood.controller;

import com.fastfoodsm.fastfood.model.Food;
import com.fastfoodsm.fastfood.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/food")
@RestController
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping
    public Iterable<Food> findAll() {
        return foodService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        return ResponseEntity.ok(foodService.getById(id));
    }

    @GetMapping("/getAllByIdCategory/{idCategory}")
    public ResponseEntity getAllByCategory(@PathVariable Long idCategory) {
        return ResponseEntity.ok(foodService.getAllByCategory(idCategory));
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Food food) {
        return ResponseEntity.ok(foodService.save(food));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        return ResponseEntity.ok(foodService.delete(id));
    }
}
