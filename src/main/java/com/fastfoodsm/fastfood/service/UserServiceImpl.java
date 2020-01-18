package com.fastfoodsm.fastfood.service;


import com.fastfoodsm.fastfood.model.Restaurant;
import com.fastfoodsm.fastfood.model.User;
import com.fastfoodsm.fastfood.repository.RestaurantRepository;
import com.fastfoodsm.fastfood.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Base64;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RestaurantRepository restaurantRepository;

    @Override
    public String save(User user) {
        userRepository.save(user);
        return "Success";
    }

    @Override
    public String createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "Successful";
    }

    @Override
    public User profile(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization")
                .substring("Basic".length()).trim();
        String username = new String(Base64.getDecoder()
                .decode(authToken)).split(":")[0];
        return userRepository.findByUsername(username);
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public ArrayList<User> getAllByEmployedAt(Long idRestaurant) {
        Restaurant restaurant = restaurantRepository.findById(idRestaurant).orElse(null);
        return userRepository.findAllByEmployedAt(restaurant);
    }

    @Override
    public String removeEmployedAt(User user) {
        user.setEmployedAt(null);
        System.out.println(user);
        userRepository.save(user);
        return "Success";
    }

    @Override
    public String addEmployedAt(String email, Long idRestaurant) {
        User user = userRepository.findByEmail(email);
        Restaurant restaurant = restaurantRepository.findById(idRestaurant).orElse(null);
        user.setEmployedAt(restaurant);
        userRepository.save(user);
        return "Success";
    }
}
