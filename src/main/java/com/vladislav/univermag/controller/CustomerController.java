package com.vladislav.univermag.controller;


import com.vladislav.univermag.dto.CustomerDTO;
import com.vladislav.univermag.entity.Customer;
import com.vladislav.univermag.service.interfaces.CustomerProductService;
import com.vladislav.univermag.service.interfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerProductService customerProductService;




    @GetMapping()
    public String getAll(Model model) {

        model.addAttribute("customers", customerService.findAllCustomers());
        return "customers/allCustomers";
    }

    @GetMapping("/{id}")
    public String getOne(@PathVariable("id") int id, Model model) {
        CustomerDTO customerDTO = customerService.findOneCustomer(id);
        customerDTO.setProductsList(customerProductService.getCustomerProductsByCustomerId(id));
        model.addAttribute("customer", customerDTO );
        return "customers/oneCustomer";
    }

    @GetMapping("/new") // вызывает форму во view и получает из нее customer
    public String newCustomer(@ModelAttribute("customer") Customer customer) {
        return "customers/new";
    }


    @PostMapping("/newCustomer")
    public String saveCustomer(@ModelAttribute("customer") CustomerDTO dtoCustomer) {
        customerService.create(dtoCustomer);
        return "redirect:/customers";
    }

    @GetMapping("{id}/update")
    public String updateCustomer(@PathVariable("id") int id, Model model) {

       CustomerDTO dtoCustomer =  customerService.findOneCustomer(id);
        model.addAttribute("customer", dtoCustomer);
        return "customers/update";
    }

    @PatchMapping("/{id}/updatedCustomer")
    public String saveUpdatedCustomer(@ModelAttribute("customer") CustomerDTO dtoCustomer, @PathVariable("id") int id) {
        dtoCustomer.setId(id);
        customerService.update(dtoCustomer);
        return "redirect:/customers";
    }



    @DeleteMapping("{id}")
    public String  deleteCustomer(@PathVariable("id") int id) {
        customerService.delete(id);
        return  "redirect:/customers";
    }


}

