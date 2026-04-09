package com.mrando.azucardj.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Profiles")
public class Profile {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  @Column(name = "last_name")
  private String lastName;
  private Integer contact;

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getId() {
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

  public void setContact(Integer contact) {
    this.contact = contact;
  }

  public Integer getContact() {
    return contact;
  }

  @Override
  public String toString() {
    return "Profile{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", lastName='" + lastName + '\'' +
      ", contact=" + contact +
      '}';
  }

}
