package com.vladislav.univermag.service.interfaces;
import com.vladislav.univermag.dto.CustomerDTO;


import java.util.List;

public interface CustomerService {

    List<CustomerDTO> findAllCustomers();

    CustomerDTO findOneCustomer(int id);

    void update(CustomerDTO customer);
    void create(CustomerDTO customer);

    void delete(int id);


}
