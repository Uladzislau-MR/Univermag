package com.vladislav.univermag.controller;

import com.vladislav.univermag.dto.CustomerDTO;
import com.vladislav.univermag.entity.Contact;
import com.vladislav.univermag.service.interfaces.ContactService;
import com.vladislav.univermag.service.interfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Transactional
public class ContactController {
    @Autowired
    ContactService contactService;
    @Autowired
    CustomerService customerService;

    @GetMapping("customers/{id}/contact/{contactId}")
    public String getUpdatingContact(@PathVariable int id,@PathVariable int contactId, Model model) {
    CustomerDTO customerDTO = customerService.findOneCustomer(id);
    model.addAttribute("customer", customerDTO);
    Contact contact = contactService.getOneContact(id, contactId);
    model.addAttribute("contact", contact);
    return "contacts/updateContact";

    }

    @PatchMapping("customers/{customerId}/contact/{contactId}")
    public String saveUpdatedContact(@PathVariable int customerId,@PathVariable int contactId,@ModelAttribute("contact") Contact contact) {
       contactService.updateContact(customerId,contactId, contact);
        return "redirect:/customers/" + customerId;
    }

}
// TODO: выпадающий список типов контакта