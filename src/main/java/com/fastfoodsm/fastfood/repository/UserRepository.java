package com.fastfoodsm.fastfood.repository;

import com.fastfoodsm.fastfood.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findById(Integer idUser);

    User findByUsername(String username);
}
