package com.mrando.azucardj.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String email;
  private String username;
  private String password;
  private Integer status;
  @Column(name = "created_at")
  private LocalDateTime createdAt;
  @Column(name = "updated_at")
  private LocalDateTime updatedAt;
  @OneToMany(targetEntity = Role.class, mappedBy = "user")
  @Column(name = "id_role")
  private Integer role;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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

  public void setRole(Integer role) {
    this.role = role;
  }

  public Integer getRole() {
    return role;
  }

  public String toString() {
    return "User{" +
      "id=" + id +
      ", email='" + email + '\'' +
      ", username='" + username + '\'' +
      ", password='" + password + '\'' +
      ", status=" + status +
      ", created_at='" + createdAt + '\'' +
      ", updated_at='" + updatedAt + '\'' +
      '}';
  }


}


