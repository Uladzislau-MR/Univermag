package com.vladislav.univermag.service;

import com.vladislav.univermag.dao.CustomerProductRepositoryImpl;
import com.vladislav.univermag.dao.interfaces.CustomerProductRepository;
import com.vladislav.univermag.entity.CustomerProduct;
import com.vladislav.univermag.service.interfaces.CustomerProductService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerProductServiceImpl implements CustomerProductService {
    @Autowired
    CustomerProductRepository customerProductRepository;

    @Override
    public List<CustomerProduct> getCustomerProductsByCustomerId(int customerId) {

        return customerProductRepository.getCustomerProductsByCustomerId(customerId);
    }

    @Override
    public List<CustomerProduct> getCustomerProductsByProductId(int productId) {
        return null;
    }
}
