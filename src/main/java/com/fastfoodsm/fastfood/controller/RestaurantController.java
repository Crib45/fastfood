package com.fastfoodsm.fastfood.controller;

import com.fastfoodsm.fastfood.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/restaurant")
@RestController
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;
}
