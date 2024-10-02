package com.core.ecomerce.controller;

import com.core.ecomerce.model.Category;
import com.core.ecomerce.model.Product;
import com.core.ecomerce.service.CategoryService;
import com.core.ecomerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    protected CategoryService categoryService;

    @GetMapping
    public String getAllProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "product-page/product-list";
    }

    @GetMapping("/{id}")
    public String getProductById(@PathVariable int id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "product-page/product-detail";
    }

    @GetMapping("/new")
    public String showProductForm(Model model) {
        model.addAttribute("product", new Product());
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "product-page/product-form";
    }

    @PostMapping
    public String saveProduct(@ModelAttribute("product") Product product, Model model) {
        try {
            productService.saveProduct(product);
            return "redirect:/products";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error saving product");
            return "product-page/product-form";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String showEditProductPage(@PathVariable("id") int id, Model model) {
        Product product = productService.getProductById(id);
        Optional<Category> category = productService.getCategoryById(product.getCateId());
        model.addAttribute("product", product);
        model.addAttribute("categoryName", category.get().getName());
        model.addAttribute("categories", productService.getAllCategories());
        return "product-page/product-edit";
    }

    @PostMapping("/{id}")
    public String updateProduct(@PathVariable int id, @ModelAttribute("product") Product product, Model model) {
        try {
            product.setId(id);
            productService.updateProduct(product);
            return "redirect:/products";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error updating product");
            return "product-page/product-form";
        }
    }

    @GetMapping("/search")
    public String searchProducts(@RequestParam("name") String name, Model model) {
        List<Product> listResult = productService.searchProductsByName(name);
        model.addAttribute("result", listResult);
        return "product-page/product-search";
    }

}