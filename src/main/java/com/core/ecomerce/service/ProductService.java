package com.core.ecomerce.service;

import com.core.ecomerce.model.Category;
import com.core.ecomerce.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface ProductService {
    List<Product> getAllProducts();
    List<Product> searchProductsByName(String name);
    List<Category> getAllCategories();
    Product getProductById(int id);
    Product saveProduct(Product product);
    void deleteProduct(int id);
    void updateProduct(Product product);
    Optional<Category> getCategoryById(int categoryId);

}