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
    public List<Contact> fetch() {
        return contactsServices.fetch();
    }

    @PostMapping
    public void save(@RequestBody Contact contact) {
        contactsServices.save(contact);
    }

    @PutMapping("/{id}")
    public Contact update(@PathVariable Integer id, @RequestBody Contact contact) {
        return contactsServices.update(id, contact);
    }

    @GetMapping("/{id}")
    public Contact getById(@PathVariable Integer id) {
        return contactsServices.findById(id);
    }

}