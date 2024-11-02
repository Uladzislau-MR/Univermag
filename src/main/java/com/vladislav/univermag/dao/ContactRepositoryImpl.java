package com.vladislav.univermag.dao;

import com.vladislav.univermag.dao.interfaces.ContactRepository;
import com.vladislav.univermag.entity.Contact;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ContactRepositoryImpl implements ContactRepository {
    @Autowired
    SessionFactory sessionFactory;

    public List<Contact> getAllContacts(int id) {
        Session session = sessionFactory.getCurrentSession();
        List<Contact> contactList = session.createQuery("from Contact", Contact.class).getResultList();
        List<Contact> customerContacts = new ArrayList<>();
        for(Contact contact: contactList) {
            if(contact.getActive()&&contact.getCustomer().getId()==id){
                System.out.println(contact.getId());
                customerContacts.add(contact);
            }

        }
        return customerContacts;
    }

}
