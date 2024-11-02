package com.vladislav.univermag.entity;


import javax.persistence.*;

@Entity
@Table(name = "contacts")
public class Contact {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @Enumerated(EnumType.STRING)
    @Column(name="contact_type")
    private ContactType contactType;
    @Column(name = "contact")
    private String contact;
    @Column(name = "active")
    private Boolean active;
    public Contact() {
    }

    public Contact(Integer id, Customer customer, ContactType contactType, String contact, Boolean active) {
        this.id = id;
        this.customer = customer;
        this.contactType = contactType;
        this.contact = contact;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ContactType getContactType() {
        return contactType;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
