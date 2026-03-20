package com.mrando.azucardj.service;

import java.util.List;
import com.mrando.azucardj.model.Contact;

public interface IContactsServices {
    List<Contact> fetch();
    void save(Contact contact);
    Contact searchById(Integer id);
    Contact updateById(Integer idContact, Contact contact);
    void deleteById(Integer id);
}
