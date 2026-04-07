package com.mrando.azucardj.model;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  private String last_name;
  private String email;
  private String username;
  private String password;
  private Integer status;
  private LocalDateTime created_at;
  private LocalDateTime updated_at;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastName() {
    return last_name;
  }

  public void setLastName(String lastName) {
    this.last_name = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  // public String getCreated_at() {
  //   return created_at;
  // }

  // public void setCreated_at(String created_at) {
  //   this.created_at = created_at;
  // }

  // public String getUpdated_at() {
  //   return updated_at;
  // }

  // public void setUpdated_at(String updated_at) {
  //   this.updated_at = updated_at;
  // }

  public String toString() {
    return "User{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", last_name='" + last_name + '\'' +
      ", email='" + email + '\'' +
      ", username='" + username + '\'' +
      ", password='" + password + '\'' +
      ", status=" + status +
      ", created_at='" + created_at + '\'' +
      ", updated_at='" + updated_at + '\'' +
      '}';
  }


}


