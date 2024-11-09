package com.vladislav.univermag.dao;

import com.vladislav.univermag.dao.interfaces.CustomerProductRepository;
import com.vladislav.univermag.entity.Customer;
import com.vladislav.univermag.entity.CustomerProduct;
import com.vladislav.univermag.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;
@Repository
public class CustomerProductRepositoryImpl implements CustomerProductRepository {
    @Autowired
    SessionFactory sessionFactory;


    @Override
    public List<CustomerProduct> getCustomerProductsByCustomerId(int customerId) {
        Session session = sessionFactory.getCurrentSession();
        List<CustomerProduct> customerProductsList = session.createQuery("from CustomerProduct", CustomerProduct.class).getResultList();
        List<CustomerProduct> resultListList = new ArrayList<>();
        for (CustomerProduct customerProduct:customerProductsList){
            if(customerProduct.getCustomer().getId()==customerId){
                 resultListList.add(customerProduct);
                return  resultListList;
            }

        }
        return null;
    }

    public void addProductToCustomer(Customer customer, Product product, int quantity){
        Session session = sessionFactory.getCurrentSession();
   CustomerProduct newCustomerProduct = new CustomerProduct();
   newCustomerProduct.setCustomer(customer);
   newCustomerProduct.setProduct(product);
   newCustomerProduct.setQuantity(quantity);
   session.save(newCustomerProduct);

    }


    @Override
    public List<CustomerProduct> getCustomerProductsByProductId(int productId) {
        return null;
    }


}
