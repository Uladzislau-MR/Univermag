package com.vladislav.univermag.convertors;

import com.vladislav.univermag.dto.CustomerDTO;
import com.vladislav.univermag.entity.Contact;
import com.vladislav.univermag.entity.Customer;
import com.vladislav.univermag.entity.CustomerProduct;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ConvertCustomerToCustomerDto extends Convertor<Customer, CustomerDTO> {


    public CustomerDTO convert(Customer customer) {
        return new Builder()
                .id(customer.getId())
                .name(customer.getName())
                .surname(customer.getSurname())
                .height(customer.getHeight())
                .birthYear(customer.getBirthYear())
                .contactsList(customer.getContacts())
                .build();
    }

    public static class Builder {
        private int id;
        private String name;
        private String surname;
        private int height;
        private int birthYear;
        private int quantity;
        private List<CustomerProduct> productsList;
        private List<Contact> contactsList;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder height(int height) {
            this.height = height;
            return this;
        }

        public Builder birthYear(int birthYear) {
            this.birthYear = birthYear;
            return this;
        }

        public Builder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder productsList(List<CustomerProduct> productsList) {
            this.productsList = productsList;
            return this;
        }

        public Builder contactsList(List<Contact> contacts) {
            this.contactsList = contacts;
            return this;
        }

        public CustomerDTO build() {
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setId(this.id);
            customerDTO.setName(this.name);
            customerDTO.setSurname(this.surname);
            customerDTO.setHeight(this.height);
            customerDTO.setBirthYear(this.birthYear);
            customerDTO.setQuantity(this.quantity);
            customerDTO.setProductsList(this.productsList);
            customerDTO.setContactList(this.contactsList);
            return customerDTO;
        }
    }
}

