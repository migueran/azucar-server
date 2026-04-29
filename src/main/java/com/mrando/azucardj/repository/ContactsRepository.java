package com.mrando.azucardj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mrando.azucardj.model.Contact;

public interface ContactsRepository extends JpaRepository<Contact, Integer> {
  @Query("SELECT c FROM Contact c JOIN c.profile p JOIN User u ON u.profile.id = p.id WHERE u.id = :userId")
  java.util.List<Contact> findByUserId(String userId);

  @Query("SELECT c FROM Contact c JOIN c.profile p JOIN User u ON u.profile.id = p.id WHERE c.id = :contactId AND u.username = :username")
  java.util.Optional<Contact> findByUserIdAndUsername(Integer contactId, String username);
}
