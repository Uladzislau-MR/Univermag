package com.vladislav.univermag.service;

import com.vladislav.univermag.convertors.ConvertCustomerDtoTOCustomer;
import com.vladislav.univermag.dao.interfaces.ContactRepository;
import com.vladislav.univermag.dao.interfaces.CustomerRepository;
import com.vladislav.univermag.dto.CustomerDTO;
import com.vladislav.univermag.entity.Contact;
import com.vladislav.univermag.entity.Customer;
import com.vladislav.univermag.entity.Product;
import com.vladislav.univermag.service.interfaces.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Contact> getAllContacts(int id) {
        return contactRepository.getAllContacts(id);
    }

    @Override
    public Contact getOneContact(int customerId, int contactId) {
        return contactRepository.getOneContact(customerId, contactId);
    }
    public void createNewContact(CustomerDTO customerDTO,Contact contact) {
        ConvertCustomerDtoTOCustomer convertCustomerDtoTOCustomer = new ConvertCustomerDtoTOCustomer();
        Customer customer = convertCustomerDtoTOCustomer.convertUpdate(customerDTO);
        contact.setCustomer(customer);
        contactRepository.createContact(contact);

    }


    @Override
    public void updateContact(int customerId, int contactId, Contact updatedContact) {
            contactRepository.updateContact(customerId,contactId, updatedContact);
    }

    @Override
    public void deleteContact(int customer, int contactId) {
        contactRepository.deleteContact(customer, contactId );
    }
}

