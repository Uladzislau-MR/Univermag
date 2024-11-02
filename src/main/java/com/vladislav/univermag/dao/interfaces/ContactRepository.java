package com.vladislav.univermag.dao.interfaces;

import com.vladislav.univermag.entity.Contact;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ContactRepository {
    List<Contact> getAllContacts(int id);


}
