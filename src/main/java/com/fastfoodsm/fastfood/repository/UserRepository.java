package com.fastfoodsm.fastfood.repository;

import com.fastfoodsm.fastfood.model.Restaurant;
import com.fastfoodsm.fastfood.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findById(Integer idUser);

    User findByUsername(String username);

    ArrayList<User> findAllByEmployedAt(Restaurant restaurant);

    User findByEmail(String email);
}
