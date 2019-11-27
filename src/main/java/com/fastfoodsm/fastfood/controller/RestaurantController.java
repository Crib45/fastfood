package com.fastfoodsm.fastfood.controller;

import com.fastfoodsm.fastfood.model.Restaurant;
import com.fastfoodsm.fastfood.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/restaurant")
@RestController
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @GetMapping
    public Iterable<Restaurant> findAll() {
        return restaurantService.getAll();
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Restaurant restaurant){
      return  ResponseEntity.ok(restaurantService.save(restaurant));
    }
}
