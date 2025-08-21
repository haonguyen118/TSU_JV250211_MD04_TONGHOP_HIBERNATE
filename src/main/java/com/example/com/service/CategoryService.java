package com.example.com.service;

import com.example.com.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category findById(Long categoryId);

    boolean save(Category category);

    boolean update(Category category);

    boolean deleteById(Long categoryId);

    boolean checkExistCategoryName(String categoryName);
}
