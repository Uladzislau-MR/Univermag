package com.vladislav.univermag.controller;

import com.vladislav.univermag.dto.ProductDto;
import com.vladislav.univermag.entity.Product;
import com.vladislav.univermag.service.ProductServiceImpl;
import com.vladislav.univermag.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping(value = "/products")
public class ProductController {
    @Autowired

    ProductService productService;
    @GetMapping()
    public List<ProductDto> findAllProducts() {
        List<ProductDto> productList = productService.getAllProducts();
        return productList;
    }
}
