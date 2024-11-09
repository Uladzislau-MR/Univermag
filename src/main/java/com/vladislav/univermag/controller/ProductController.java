package com.vladislav.univermag.controller;

import com.vladislav.univermag.dto.ProductDto;

import com.vladislav.univermag.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
@RequestMapping(value = "/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping()
    public String findAllProducts(Model model) {
        List<ProductDto> productList = productService.getAllProducts();
        model.addAttribute("products", productList);
        return "products/allProducts";
    }
}
