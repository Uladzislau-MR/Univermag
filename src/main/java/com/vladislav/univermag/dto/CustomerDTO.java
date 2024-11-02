package com.vladislav.univermag.dto;

import com.vladislav.univermag.entity.Contact;
import com.vladislav.univermag.entity.ContactType;
import com.vladislav.univermag.entity.CustomerProduct;
import com.vladislav.univermag.entity.Product;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.ArrayList;
import java.util.List;

public class CustomerDTO {
    private int id;
    private String name;
    private String surname;
    private int height;
    private int birthYear;
    private int quantity;
    private List<CustomerProduct> productsList;
    private List<Contact> contactsList;
    public CustomerDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<CustomerProduct> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<CustomerProduct> productsList) {
        this.productsList = productsList;
    }

    public List<Contact> getContactsList() {
        return contactsList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactsList = contactList;
    }
}
