package com.mrando.azucardj.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mrando.azucardj.model.Contact;

@Repository
public interface ContactsRepository extends CrudRepository<Contact, Integer> {
}