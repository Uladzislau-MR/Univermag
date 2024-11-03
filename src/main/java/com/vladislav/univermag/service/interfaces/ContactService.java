package com.vladislav.univermag.service.interfaces;

import com.vladislav.univermag.entity.Contact;
import com.vladislav.univermag.entity.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ContactService {
    List<Contact> getAllContacts(int id);
    Contact getOneContact(int customer, int contactId);
    void updateContact(int customerId, int contactId, Contact updatedContact);
    void deleteContact(int customer, int contactId);
}
