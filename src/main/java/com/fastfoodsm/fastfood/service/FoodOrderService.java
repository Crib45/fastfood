package com.fastfoodsm.fastfood.service;

import com.fastfoodsm.fastfood.model.FoodOrder;
import org.springframework.stereotype.Service;

@Service
public interface FoodOrderService {
    FoodOrder save(FoodOrder foodOrder);
}
