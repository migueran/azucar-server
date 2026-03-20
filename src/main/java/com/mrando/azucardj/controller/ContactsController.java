package com.mrando.azucardj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mrando.azucardj.model.Contact;
import com.mrando.azucardj.service.ContactsServices;

@RestController
@RequestMapping("/contacts")
public class ContactsController {

    @Autowired
    private ContactsServices contactsServices;

    @GetMapping
    public List<Contact> fetchContacts() {
        return contactsServices.fetch();
    }

    @PostMapping
    public void saveContact(@RequestBody Contact contact) {
        contactsServices.save(contact);
    }

    @PutMapping("/{id}")
    public Contact updateContactById(@PathVariable Integer id, @RequestBody Contact contact) {
        return contactsServices.updateById(id, contact);
    }

    @GetMapping("/{id}")
    public Contact getContactById(@PathVariable Integer id) {
        return contactsServices.searchById(id);
    }

}