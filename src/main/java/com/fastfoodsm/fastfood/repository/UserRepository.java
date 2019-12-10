package com.fastfoodsm.fastfood.repository;

import com.fastfoodsm.fastfood.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findById(Integer idUser);
    public User findByUsername(String username);
}
