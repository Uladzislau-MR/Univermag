package com.vladislav.univermag.service;

import com.vladislav.univermag.dao.ProductRepository;
import com.vladislav.univermag.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

@Transactional
    public List<Product> findAllProducts() {
        List<Product> productList = productRepository.findAllProducts();
        return productList;
    }
}
