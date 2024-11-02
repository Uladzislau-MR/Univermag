package com.vladislav.univermag.service.interfaces;

import com.vladislav.univermag.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts ();
    ProductDto getOneProduct(int id);
    void create (ProductDto productDto);
    void update (ProductDto productDto);
    void delete (int id);
}
