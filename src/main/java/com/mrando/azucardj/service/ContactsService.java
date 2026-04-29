package com.mrando.azucardj.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mrando.azucardj.model.Contact;
import com.mrando.azucardj.model.Network;
import com.mrando.azucardj.model.Profile;
import com.mrando.azucardj.repository.ContactsRepository;
import com.mrando.azucardj.service.Interfaces.IContactsService;

@Service
public class ContactsService implements IContactsService {

    @Autowired
    private ContactsRepository repoContacts;

    @Autowired
    private NetworksService networkService;

    @Autowired
    private UsersService userService;

    @Override
    public List<Contact> fetch() {
        return (List<Contact>) repoContacts.findAll();
    }

    @Override
    public List<Contact> findByUserId(String userId) {
        return repoContacts.findByUserId(userId);
    }

    @Override
    public void save(Contact contact, String username) {
        if (contact.getProfile() == null) {
            Profile profile = userService.findByUsername(username).getProfile();
            if (profile == null) {
                throw new RuntimeException("El usuario no tiene un perfil asociado");
            }
            contact.setProfile(profile);
        }

        repoContacts.save(contact);
    }

    @Override
    public Contact findById(Integer id) {
        return repoContacts.findById(id).orElse(null);
    }

    @Override
    public Contact update(Integer idContact, Contact contact, String username) {
        Contact existingContact = repoContacts.findByUserIdAndUsername(idContact, username).orElse(null);
        if (existingContact != null) {
            Network newNetwork = networkService.findById(contact.getNetwork().getId());
            existingContact.update(newNetwork, contact.getUrl());
            return repoContacts.save(existingContact);
        } else {
            throw new RuntimeException("El contacto no pertenece al usuario actual o no existe");
        }
    }

    @Override
    public void delete(Integer id) {
        repoContacts.deleteById(id);
    }

}