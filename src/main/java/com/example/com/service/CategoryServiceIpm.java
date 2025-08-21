package com.example.com.service;

import com.example.com.model.Category;
import com.example.com.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceIpm implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long categoryId) {
       return categoryRepository.findById(categoryId);
    }

    @Override
    public boolean save(Category category) {
        return  categoryRepository.save(category);
    }

    @Override
    public boolean update(Category category) {
       return  categoryRepository.update(category);
    }

    @Override
    public boolean deleteById(Long categoryId) {
        return categoryRepository.deleteById(categoryId);
    }

    @Override
    public boolean checkExistCategoryName(String categoryName) {
        return categoryRepository.checkExistCategoryName(categoryName);
    }
}
