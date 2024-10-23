package com.vladislav.univermag.dao.interfaces;

import com.vladislav.univermag.entity.Customer;
import org.hibernate.Session;

import java.util.List;

public interface CustomerRepository {

    public List<Customer> findAllCustomers();

    public Customer findOneCustomer(int id);

    public void createOrUpdate(Customer updatedCustomer);

    public void delete(int id);

}