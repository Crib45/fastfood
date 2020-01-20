package com.fastfoodsm.fastfood.controller;

import com.fastfoodsm.fastfood.model.FoodOrder;
import com.fastfoodsm.fastfood.model.Order;
import com.fastfoodsm.fastfood.model.User;
import com.fastfoodsm.fastfood.model.customTypes.StatusType;
import com.fastfoodsm.fastfood.service.FoodOrderService;
import com.fastfoodsm.fastfood.service.OrderService;
import com.fastfoodsm.fastfood.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    FoodOrderService foodOrderService;

    @Autowired
    UserService userService;

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
        System.out.println(order);
        return ResponseEntity.ok(orderService.save(order));
    }

    @GetMapping("/getAllByIdRestaurantAndStatus/{idRestaurant}/{orderStatus}")
    public ResponseEntity getAllByIdRestaurantAndStatus(@PathVariable Long idRestaurant,@PathVariable String orderStatus){
        return ResponseEntity.ok(orderService.getOrderByIdRestaurantAndStatus(idRestaurant,orderStatus));
    }

    @PostMapping("/foodOrder/save")
    public ResponseEntity saveFoodOrder(@RequestBody FoodOrder foodOrder) {
        return ResponseEntity.ok(foodOrderService.save(foodOrder));
    }

    @PostMapping("/saveChange")
    public ResponseEntity saveChange(@RequestBody Order order){
        System.out.println(order);
        return ResponseEntity.ok(orderService.save(order));
    }
}
