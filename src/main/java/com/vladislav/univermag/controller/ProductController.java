package com.vladislav.univermag.controller;

import com.vladislav.univermag.entity.Product;
import com.vladislav.univermag.service.CustomerService;
import com.vladislav.univermag.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("/products")
    public List<Product> findAllProducts() {
        List<Product> productList = productService.findAllProducts();
        return productList;
    }
}
