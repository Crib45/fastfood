package com.fastfoodsm.fastfood.service;


import com.fastfoodsm.fastfood.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;


}
