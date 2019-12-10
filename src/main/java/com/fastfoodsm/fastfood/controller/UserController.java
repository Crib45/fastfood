package com.fastfoodsm.fastfood.controller;


import com.fastfoodsm.fastfood.model.User;
import com.fastfoodsm.fastfood.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Base64;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;


    @RequestMapping("/login")
    public boolean login(@RequestBody User user) {
        return user.getUsername().equals("user") && user.getPassword().equals("password");
    }

    @RequestMapping("/user")
    public Principal user(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization")
                .substring("Basic".length()).trim();
        return () ->  new String(Base64.getDecoder()
                .decode(authToken)).split(":")[0];
    }

    @RequestMapping("/profile")
    public ResponseEntity profile(HttpServletRequest request) {
        return ResponseEntity.ok(userService.profile(request));
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void logout(HttpSession session) {
        session.invalidate();
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody User user){
        System.out.println(user);
        return ResponseEntity.ok(userService.createUser(user));
    }
}
