package com.vladislav.univermag.service;

import com.vladislav.univermag.convertors.ConvertCustomerDtoTOCustomer;
import com.vladislav.univermag.convertors.ConvertCustomerToCustomerDto;
import com.vladislav.univermag.dao.CustomerRepositoryImpl;
import com.vladislav.univermag.dao.interfaces.ContactRepository;
import com.vladislav.univermag.dto.CustomerDTO;
import com.vladislav.univermag.entity.Customer;
import com.vladislav.univermag.service.interfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
//import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepositoryImpl customerRepositoryImpl;
    @Autowired
    ConvertCustomerToCustomerDto convertToCustomerDto;
    @Autowired
    ConvertCustomerDtoTOCustomer convertToCustomer;
    @Autowired
    private ContactRepository contactRepository;




    public List<CustomerDTO> findAllCustomers() {
        List<Customer> customerList = customerRepositoryImpl.findAllCustomers();
        List<CustomerDTO> dtoList = new ArrayList<>();
        for(Customer customer:customerList ) {
         dtoList.add(  convertToCustomerDto.convert(customer));
        }
         return dtoList;
    }


    public CustomerDTO findOneCustomer(int id) {

        Customer customer = customerRepositoryImpl.findOneCustomer(id);
        CustomerDTO customerDTO = convertToCustomerDto.convert(customer);
        customerDTO.setContactList(contactRepository.getAllContacts(id));
        return customerDTO;
    }


    public void update(CustomerDTO dtoCustomer) {
        customerRepositoryImpl.update(convertToCustomer.convertUpdate(dtoCustomer));
    }

    public void create(CustomerDTO dtoCustomer) {
        customerRepositoryImpl.create(convertToCustomer.convert(dtoCustomer));
    }

    public void delete(int id) {
        customerRepositoryImpl.delete(id);
    }


}
