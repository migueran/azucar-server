package com.mrando.azucardj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mrando.azucardj.model.Contact;

public interface ContactsRepository extends JpaRepository<Contact, Integer> {
}