package com.fastfoodsm.fastfood.controller;

import com.fastfoodsm.fastfood.model.Order;
import com.fastfoodsm.fastfood.model.customTypes.StatusType;
import com.fastfoodsm.fastfood.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/getAllByIdUser/{idUser}")
    public ResponseEntity getAllByIdUser(@PathVariable Long idUser) {
        return ResponseEntity.ok(orderService.getAllByIdUser(idUser));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.deleteById(id));
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.save(order));
    }

    @GetMapping("/getAllByIdRestaurantAndStatus/{idRestaurant}/{statusType}")
    public ResponseEntity getAllByIdRestaurantAndStatus(@PathVariable Long idRestaurant,@PathVariable StatusType statusType){
        return ResponseEntity.ok(orderService.getOrderByIdRestaurantAndStatus(idRestaurant,statusType));
    }
}
