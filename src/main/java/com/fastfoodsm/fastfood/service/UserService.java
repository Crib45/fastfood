package com.fastfoodsm.fastfood.service;

import com.fastfoodsm.fastfood.model.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    String createUser(User user);
    User profile(HttpServletRequest request);
    User getByUsername(String username);
}
