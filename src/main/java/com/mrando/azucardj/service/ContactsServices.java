package com.mrando.azucardj.service;

// import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrando.azucardj.model.Contact;
import com.mrando.azucardj.repository.ContactsRepository;

@Service
public class ContactsServices implements IContactsServices {

    @Autowired
    private ContactsRepository repoContacts;

    @Override
    public List<Contact> fetch() {
        return (List<Contact>) repoContacts.findAll();
    }

    @Override
    public void save(Contact contact) {
        repoContacts.save(contact);
    }

    @Override
    public Contact searchById(Integer id) {
        return repoContacts.findById(id).orElse(null);
    }

    @Override
    public Contact updateById(Integer idContact, Contact contact) {
      repoContacts.findById(idContact).ifPresent(existingContact -> {
            repoContacts.save(existingContact);
        });
        return repoContacts.findById(idContact).orElse(null);
      }

    @Override
    public void deleteById(Integer id) {
        repoContacts.deleteById(id);
    }

}