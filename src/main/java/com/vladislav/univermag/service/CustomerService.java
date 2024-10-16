package com.vladislav.univermag.service;

import com.vladislav.univermag.dao.CustomerRepository;
import com.vladislav.univermag.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Transactional
    public List<Customer> findAllCustomers() {
        return customerRepository.findAllCustomers();
    }
    @Transactional
    public Customer findOneCustomer(int id) {
        return customerRepository.findOneCustomer(id);
    }
}
