package com.vladislav.univermag.dao;

import com.vladislav.univermag.dao.interfaces.ProductRepository;
import com.vladislav.univermag.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    @Autowired
    SessionFactory sessionFactory;

    public List<Product> getAllProducts() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Product", Product.class).getResultList();
    }


    public Product getOneProduct(int id) {
        List<Product> productList = getAllProducts();
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void create(Product newProduct) {
        Session session = sessionFactory.getCurrentSession();
        session.save(newProduct);
    }

    @Override
    public void update(Product product) {
    Session session = sessionFactory.getCurrentSession();
      session.update(product);
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = getOneProduct(id);
        session.delete(product);
    }
}
