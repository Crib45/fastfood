package com.fastfoodsm.fastfood.service;

import com.fastfoodsm.fastfood.model.FoodOrder;
import com.fastfoodsm.fastfood.repository.FoodOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodOrderServiceImpl implements FoodOrderService {
    @Autowired
    FoodOrderRepository foodOrderRepository;

    @Override
    public FoodOrder save(FoodOrder foodOrder) {
        foodOrderRepository.save(foodOrder);
        return foodOrder;
    }
}
