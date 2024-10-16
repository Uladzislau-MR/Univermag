package com.vladislav.univermag.dao;

import com.vladislav.univermag.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {
    @Autowired
    SessionFactory sessionFactory;

    public List<Product> findAllProducts() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("from Product", Product.class).getResultList();
    }


}
