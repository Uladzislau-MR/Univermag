package com.vladislav.univermag.controller;

import com.vladislav.univermag.entity.Customer;
import com.vladislav.univermag.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;
@Controller
//@RequestMapping(value = "/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/all")
    public String findAllCustomers(Model model) {
        List<Customer> customerList = customerService.findAllCustomers();
        System.out.println("customerList = " + customerList);
        model.addAttribute("customers", customerService.findAllCustomers());


        return "customers/allCustomers"; // Возвращает представление
    }
//    @GetMapping("/{id}")
//    public String findOneCustomer(@PathVariable("id") int id, Model model) {
//
//        model.addAttribute("customer", customerService.findOneCustomer(id));
//
//        return "customers/allCustomers";
//    }
//


}

