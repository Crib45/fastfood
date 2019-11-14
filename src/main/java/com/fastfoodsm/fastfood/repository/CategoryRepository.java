package com.fastfoodsm.fastfood.repository;

import com.fastfoodsm.fastfood.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
