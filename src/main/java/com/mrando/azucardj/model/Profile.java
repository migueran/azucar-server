package com.mrando.azucardj.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Profiles")
public class Profile {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
  @Column(name = "last_name")
  private String lastName;
  private String email;
  @OneToMany(
    targetEntity = Contact.class,
    fetch = FetchType.LAZY,
    mappedBy = "profile"
  )
  @JsonManagedReference
  private List<Contact> contact;

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setContact(List<Contact> contact) {
    this.contact = contact;
  }

  public void addContact(Contact contact) {
    this.contact.add(contact);
  }

  public List<Contact> getContact() {
    return contact;
  }

  @Override
  public String toString() {
    return "Profile{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", lastName='" + lastName + '\'' +
      ", email='" + email + '\'' +
      ", contact=" + contact +
      '}';
  }

}
