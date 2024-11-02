package com.vladislav.univermag.dao.interfaces;

import com.vladislav.univermag.entity.Product;

import java.util.List;

public interface ProductRepository {

    public List<Product> getAllProducts();
    public Product getOneProduct(int id);
    public void create(Product newProduct);
    public void update(Product product);
    public void delete(int id);

}
