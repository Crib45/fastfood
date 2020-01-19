package com.fastfoodsm.fastfood.controller;


import com.fastfoodsm.fastfood.model.Favorites;
import com.fastfoodsm.fastfood.model.User;
import com.fastfoodsm.fastfood.service.FavoritesService;
import com.fastfoodsm.fastfood.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import sun.security.util.Password;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Base64;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    FavoritesService favoritesService;

    @RequestMapping("/login")
    public boolean login(@RequestBody User user) {
        User userCheck = userService.getByUsername(user.getUsername());
        if (userCheck != null) {
            return passwordEncoder.matches(user.getPassword(), userCheck.getPassword());
        } else return false;
    }

    @RequestMapping("/user")
    public Principal user(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization")
                .substring("Basic".length()).trim();
        System.out.println(authToken);
        return () -> new String(Base64.getDecoder()
                .decode(authToken)).split(":")[0];
    }

    @GetMapping("/profile")
    public ResponseEntity profile(HttpServletRequest request) {
        return ResponseEntity.ok(userService.profile(request));
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void logout(HttpSession session) {
        session.invalidate();
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody User user) {
        System.out.println(user);
        return ResponseEntity.ok(userService.createUser(user));
    }

    @PostMapping("/save")
    public ResponseEntity saveUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping("/getAllUsersEmployedBy/{idRestaurant}")
    public ResponseEntity getAllUsersEmployedBy(@PathVariable Long idRestaurant) {
        return ResponseEntity.ok(userService.getAllByEmployedAt(idRestaurant));
    }

    @PostMapping("/removeUserEmployedAt")
    public ResponseEntity removeUserEmployedAt(@RequestBody User user) {
        return ResponseEntity.ok(userService.removeEmployedAt(user));
    }

    @PostMapping("/addUserEmployedAt/{idRestaurant}")
    public ResponseEntity addUserEmployedAt(@RequestBody String email, @PathVariable Long idRestaurant) {
        return ResponseEntity.ok(userService.addEmployedAt(email, idRestaurant));
    }

    @GetMapping("/addToFavorites/{idRestaurant}")
    public ResponseEntity addToFavorites(@PathVariable Long idRestaurant, HttpServletRequest request) {
        User user = userService.profile(request);
        return ResponseEntity.ok(favoritesService.save(idRestaurant, user));
    }

    @GetMapping("/getFavorites")
    public ResponseEntity getFavorites(HttpServletRequest request) {
        User user = userService.profile(request);
        return ResponseEntity.ok(favoritesService.getAllByUser(user));
    }

    @DeleteMapping("/deleteFavorite/{favoriteId}")
    public ResponseEntity deleteFavorite(@PathVariable Long favoriteId){
        return ResponseEntity.ok(favoritesService.delete(favoriteId));
    }
}
