package com.example.com.repository;

import com.example.com.model.Category;

import java.util.List;

public interface CategoryRepository {
    List<Category> findAll();

    Category findById(Long categoryId);

    boolean save(Category category);

    boolean update(Category category);

    boolean deleteById(Long categoryId);

    boolean checkExistCategoryName(String categoryName);
}
