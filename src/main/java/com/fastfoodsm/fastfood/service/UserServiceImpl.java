package com.fastfoodsm.fastfood.service;


import com.fastfoodsm.fastfood.model.User;
import com.fastfoodsm.fastfood.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;


    @Override
    public String createUser(User user) {
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
}
