package com.vladislav.univermag.convertors;

import com.vladislav.univermag.dto.CustomerDTO;
import com.vladislav.univermag.entity.Contact;
import com.vladislav.univermag.entity.Customer;
import com.vladislav.univermag.entity.CustomerProduct;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ConvertCustomerDtoTOCustomer extends Convertor <CustomerDTO,Customer>{
    @Override
    public Customer convert(CustomerDTO customerDTO) {
        return new Builder()
                .name(customerDTO.getName())
                .surname(customerDTO.getSurname())
                .birthYear(customerDTO.getBirthYear())
                .height(customerDTO.getHeight())
                .build();
       }

    public Customer convertUpdate(CustomerDTO customerDTO) {
                return new Builder()
                    .id(customerDTO.getId())
                    .name(customerDTO.getName())
                    .surname(customerDTO.getSurname())
                    .birthYear(customerDTO.getBirthYear())
                    .height(customerDTO.getHeight())
                    .build();
        }


    public static class Builder{
        private int id;
        private String name;
        private String surname;
        private int height;
        private int birthYear;
        private int quantity;



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



        public Customer build() {
            Customer customer = new Customer();
            customer.setId(this.id);
            customer.setName(this.name);
            customer.setSurname(this.surname);
            customer.setHeight(this.height);
            customer.setBirthYear(this.birthYear);
            return customer;
        }
    }
}
