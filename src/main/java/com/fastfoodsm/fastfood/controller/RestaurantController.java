package com.fastfoodsm.fastfood.controller;

import com.fastfoodsm.fastfood.model.Restaurant;
import com.fastfoodsm.fastfood.model.User;
import com.fastfoodsm.fastfood.service.RestaurantService;
import com.fastfoodsm.fastfood.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/restaurant")
@RestController
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @Autowired
    UserService userService;

    @GetMapping
    public Iterable<Restaurant> findAll() {
        return restaurantService.getAll();
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Restaurant restaurant){
      return  ResponseEntity.ok(restaurantService.save(restaurant));
    }

    @GetMapping("/getAllOwnedByUser")
    public ResponseEntity getAllOwnedByUser(HttpServletRequest request){
        User user = userService.profile(request);
       return ResponseEntity.ok(restaurantService.getByUser(user));
    }

    @GetMapping("/getByEmployee")
    public ResponseEntity getByEmployee(HttpServletRequest request){
        User user = userService.profile(request);
        return ResponseEntity.ok(restaurantService.getByEmployee(user));
    }

    @GetMapping("/{idRestaurant}")
    public ResponseEntity getById(@PathVariable Long idRestaurant){
        return ResponseEntity.ok(restaurantService.getById(idRestaurant));
    }
}
