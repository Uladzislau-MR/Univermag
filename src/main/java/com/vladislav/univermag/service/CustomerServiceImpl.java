package com.vladislav.univermag.service;

import com.vladislav.univermag.dao.CustomerRepositoryImpl;
import com.vladislav.univermag.dto.CustomerCreationDTO;
import com.vladislav.univermag.dto.CustomerViewDTO;
import com.vladislav.univermag.entity.Customer;
import com.vladislav.univermag.service.interfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
//import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Transactional
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepositoryImpl customerRepositoryImpl;

    public CustomerCreationDTO convertToCreationDTO(Customer customer) {
        return new CustomerCreationDTO(customer.getId(), customer.getName(), customer.getSurname(),
                customer.getBirthYear(), customer.getHeight());
    }

    public CustomerViewDTO convertToViewDTO(Customer customer) {
        CustomerViewDTO customerViewDTO = new CustomerViewDTO(customer.getId(), customer.getName(),
                customer.getSurname(), customer.getHeight());
        customerViewDTO.setProducts(customer.getProducts());
//        if(!customerViewDTO.getProducts().isEmpty()){
//            
//        }
        // TODO: проверить как отображается список продуктов
        return customerViewDTO;
    }

    public Customer convertToEntity(CustomerCreationDTO customerDTO) {
        Customer customer = new Customer();

        customer.setName(customerDTO.getName());
        customer.setSurname(customerDTO.getSurname());
        customer.setBirthYear(customerDTO.getBirthYear());
        customer.setHeight(customerDTO.getHeight());

        return customer;
    }

    public List<CustomerViewDTO> findAllCustomers() {
        List<Customer> customerList = customerRepositoryImpl.findAllCustomers();
        return customerList.stream()
                .map(customer -> {
                    CustomerViewDTO customerViewDTO = new CustomerViewDTO();
                    customerViewDTO.setId(customer.getId());
                    customerViewDTO.setName(customer.getName());
                    customerViewDTO.setSurname(customer.getSurname());
                    customerViewDTO.setHeight(customer.getHeight());

                    return customerViewDTO;
                })
                .collect(Collectors.toList());
    }


    public CustomerViewDTO findOneCustomer(int id) {

        Customer customer = customerRepositoryImpl.findOneCustomer(id);
        CustomerViewDTO customerViewDTO = convertToViewDTO(customer);
        customer.getProducts().size(); // костыль для принудительной инициализации

        return customerViewDTO;
    }


    public void createOrUpdate(CustomerCreationDTO dtoCustomer) {
    customerRepositoryImpl.createOrUpdate(convertToEntity(dtoCustomer));
    }


    public void delete(int id) {
        customerRepositoryImpl.delete(id);
    }


}
