package com.mrando.azucardj.service.Interfaces;

import java.util.List;
import com.mrando.azucardj.model.Contact;

public interface IContactsService {
    List<Contact> fetch();
    List<Contact> findByUserId(String userId);
    Contact findById(Integer id);
    void save(Contact contact, String username);
    Contact update(Integer idContact, Contact contact, String username);
    void delete(Integer id);
}
