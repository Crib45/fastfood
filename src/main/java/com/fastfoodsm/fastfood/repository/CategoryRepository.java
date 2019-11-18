package com.fastfoodsm.fastfood.repository;

import com.fastfoodsm.fastfood.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
