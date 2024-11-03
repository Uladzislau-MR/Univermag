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
        for (Contact contact : contactList) {
            if (contact.getActive() && contact.getCustomer().getId() == id) {

                customerContacts.add(contact);
            }

        }
        return customerContacts;
    }

    public Contact getOneContact(int customerId, int contactId) {
        List<Contact> contactList = getAllContacts(customerId);

        for (Contact contact : contactList) {
            if (contact.getId() == contactId) {
                return contact;
            }

        }
        return null;
    }


    public void updateContact(int customerId, int contactId, Contact updatedContact) {
        Session session = sessionFactory.getCurrentSession();

        List<Contact> contactList = getAllContacts(customerId);
        for (Contact contact : contactList) {
            if (contactId == contact.getId()) {

//                updatedContact.setContact(contact.getContact());
//                updatedContact.setContactType(contact.getContactType());
                updatedContact.setCustomer(contact.getCustomer());
                updatedContact.setActive(true);
                contact.setActive(false);
                session.save(updatedContact);

            }
        }

    }

    public void deleteContact(int customerId, int contactId) {
        Session session = sessionFactory.getCurrentSession();
        List<Contact> contactList = getAllContacts(customerId);
        for (Contact contact : contactList) {
            if (contactId == contact.getId()) {
                contact.setActive(false);
                session.save(contact);

            }
        }

    }


}
