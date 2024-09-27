package com.core.ecomerce.service;

import com.core.ecomerce.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(int id);
    void saveCategory(Category category);
    void deleteCategory(int id);
}
