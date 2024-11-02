package com.vladislav.univermag.service;

import com.vladislav.univermag.convertors.ConvertProductDtoToProduct;
import com.vladislav.univermag.convertors.ConvertProductToProductDto;
import com.vladislav.univermag.dao.ProductRepositoryImpl;
import com.vladislav.univermag.dto.ProductDto;
import com.vladislav.univermag.entity.Product;
import com.vladislav.univermag.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Transactional
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepositoryImpl productRepositoryImpl;
    @Autowired
    ConvertProductToProductDto convertProductToProductDto;
    @Autowired
    ConvertProductDtoToProduct convertProductDtoToProduct;


    public List<ProductDto> getAllProducts() {
        List<Product> productList = productRepositoryImpl.getAllProducts();
        List<ProductDto> productDtoList = new ArrayList<>();
        for (Product product : productList) {
            ProductDto productDto = convertProductToProductDto.convert(product);
            productDtoList.add(productDto);
            return productDtoList;
        }
        return productDtoList;
    }

    @Override
    public ProductDto getOneProduct(int id) {
        Product product = productRepositoryImpl.getOneProduct(id);
        ProductDto productDto = convertProductToProductDto.convert(product);
        return productDto;
    }

    @Override
    public void create(ProductDto productDto) {
    Product product =  convertProductDtoToProduct.convert(productDto);
    productRepositoryImpl.create(product);
    }

    @Override
    public void update(ProductDto productDto) {
        Product product =  convertProductDtoToProduct.convert(productDto);
        productRepositoryImpl.update(product);
    }

    @Override
    public void delete(int id) {

    }
}
