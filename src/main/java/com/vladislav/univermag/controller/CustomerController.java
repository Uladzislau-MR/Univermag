package com.vladislav.univermag.controller;

import com.vladislav.univermag.dto.CustomerCreationDTO;
import com.vladislav.univermag.dto.CustomerViewDTO;
import com.vladislav.univermag.entity.Customer;
import com.vladislav.univermag.service.CustomerServiceImpl;
import com.vladislav.univermag.service.interfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@Controller
@RequestMapping(value = "/customers")
public class CustomerController  {
    @Autowired
    private CustomerService customerService;

    @GetMapping()
    public String getAll(Model model) {
        List<CustomerViewDTO> customerList = customerService.findAllCustomers();

        model.addAttribute("customers", customerService.findAllCustomers());


        return "customers/allCustomers";
    }
    @GetMapping("/{id}")
    public String getOne(@PathVariable("id") int id, Model model) {
        System.out.println();
        model.addAttribute("customer", customerService.findOneCustomer(id));

        return "customers/oneCustomer";
    }

    @GetMapping("/new") // вызывает форму во view и получает из нее customer
    public String newCustomer(@ModelAttribute("customer") Customer customer) {
        return "customers/new";
    }


    @PostMapping("/newCustomer")
    public String saveCustomer(@ModelAttribute("customer") CustomerCreationDTO dtoCustomer) {
      customerService.createOrUpdate(dtoCustomer);
        return "redirect:/customers";
    }

@GetMapping("{id}/update")
public String updateCustomer(@PathVariable("id") int id, Model model) {

    CustomerCreationDTO dtoCustomer = new CustomerCreationDTO();
    dtoCustomer.setId(id);
    model.addAttribute("customer", dtoCustomer);
    return "customers/update";
}

    @PatchMapping("/{id}/updatedCustomer")
    public String saveUpdatedCustomer(@ModelAttribute("customer") CustomerCreationDTO dtoCustomer, @PathVariable("id") int id) {
        System.out.println("Saving updated customer with id: " + id);
        dtoCustomer.setId(id);
        customerService.createOrUpdate(dtoCustomer);
        return "redirect:/customers";
    }



}

