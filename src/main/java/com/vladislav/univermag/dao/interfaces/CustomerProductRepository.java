package com.vladislav.univermag.dao.interfaces;

import com.vladislav.univermag.entity.CustomerProduct;

import java.util.List;

public interface CustomerProductRepository {
    public List<CustomerProduct> getCustomerProductsByCustomerId(int customerId);
    public List<CustomerProduct> getCustomerProductsByProductId(int productId);
}
