package com.vladislav.univermag.service;

import com.vladislav.univermag.dao.customerRepositoryImplImpl;
import com.vladislav.univermag.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    customerRepositoryImplImpl customerRepositoryImpl;

    @Transactional
    public List<Customer> findAllCustomers() {
        return customerRepositoryImpl.findAllCustomers();
    }


    @Transactional
    public Customer findOneCustomer(int id) {
        Customer customer = customerRepositoryImpl.findOneCustomer(id);
        customer.getProducts().size(); // костыль для принудительной инициализации

        return customer;
    }

    @Transactional
    public void createOrUpdate(Customer customer) {
        customerRepositoryImpl.createOrUpdate(customer);
    }

    @Transactional
    public void delete(int id) {
        customerRepositoryImpl.delete(id);
    }


}
