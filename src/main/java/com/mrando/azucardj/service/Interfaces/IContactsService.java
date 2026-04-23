package com.mrando.azucardj.service.Interfaces;

import java.util.List;
import com.mrando.azucardj.model.Contact;

public interface IContactsService {
    List<Contact> fetch();
    void save(Contact contact);
    Contact findById(Integer id);
    Contact update(Integer idContact, Contact contact);
    void delete(Integer id);
}
