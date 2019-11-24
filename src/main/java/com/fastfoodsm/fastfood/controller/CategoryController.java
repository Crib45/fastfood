package com.fastfoodsm.fastfood.controller;

import com.fastfoodsm.fastfood.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/category")
@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;
}
