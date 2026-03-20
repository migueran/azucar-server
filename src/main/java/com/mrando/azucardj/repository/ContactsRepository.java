package com.mrando.azucardj.repository;

import org.springframework.data.repository.CrudRepository;

import com.mrando.azucardj.model.Contact;

public interface ContactsRepository extends CrudRepository<Contact, Integer> {
}