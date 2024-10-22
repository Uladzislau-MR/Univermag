package com.vladislav.univermag.dao;

import com.vladislav.univermag.dao.interfaces.CustomerRepository;
import com.vladislav.univermag.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class customerRepositoryImpl implements CustomerRepository {


    @Autowired
    SessionFactory sessionFactory;

    public List<Customer> findAllCustomers() {
        Session session = sessionFactory.getCurrentSession();
        List<Customer> customerList = session.createQuery("from Customer", Customer.class).getResultList();
        return customerList;
    }


    public Customer findOneCustomer(int id) {

        List<Customer>  customerList = findAllCustomers();
        for (Customer customer:customerList) {
            if(customer.getId()==id){
                return customer;
            }
        }
        return null;
    }

    public void createOrUpdate(Customer updatedCustomer) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(updatedCustomer);
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class, id);
        session.delete(customer);
    }


}
