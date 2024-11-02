package com.vladislav.univermag.service.interfaces;

import com.vladislav.univermag.entity.CustomerProduct;

import java.util.List;

public interface CustomerProductService {

    public List<CustomerProduct> getCustomerProductsByCustomerId(int customerId);
    public List<CustomerProduct> getCustomerProductsByProductId(int productId);
}
