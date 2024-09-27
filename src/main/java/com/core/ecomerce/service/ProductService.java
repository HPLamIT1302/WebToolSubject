package com.core.ecomerce.service;

import com.core.ecomerce.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(int id);
    Product saveProduct(Product product);
    void deleteProduct(int id);
    void updateProduct(Product product);
}