package com.vladislav.univermag.service.interfaces;

import com.vladislav.univermag.dto.CustomerCreationDTO;
import com.vladislav.univermag.dto.CustomerViewDTO;
import com.vladislav.univermag.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<CustomerViewDTO> findAllCustomers();

    CustomerViewDTO findOneCustomer(int id);

    void createOrUpdate(CustomerCreationDTO customer);

    void delete(int id);


}
