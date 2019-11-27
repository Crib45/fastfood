package com.fastfoodsm.fastfood.service;

import com.fastfoodsm.fastfood.model.Order;
import com.fastfoodsm.fastfood.model.User;
import com.fastfoodsm.fastfood.repository.OrderRepository;
import com.fastfoodsm.fastfood.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements  OrderService{
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<Order> getAllByIdUser(Long idUser) {
        User user = userRepository.findById(idUser).get();
        return orderRepository.findAllByUserId(user);
    }

    @Override
    public Order getById(Long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public String deleteById(Long id) {
        orderRepository.deleteById(id);
        return "Success";
    }

    @Override
    public String save(Order order) {
        orderRepository.save(order);
        return "Success";
    }
}
