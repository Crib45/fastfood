package com.fastfoodsm.fastfood.service;


import com.fastfoodsm.fastfood.model.User;
import com.fastfoodsm.fastfood.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;


    @Override
    public String createUser(User user) {
        userRepository.save(user);
        return "Successful";
    }
}
