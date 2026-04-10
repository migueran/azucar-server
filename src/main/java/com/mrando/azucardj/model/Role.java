package com.mrando.azucardj.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Roles")
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String role;
  @OneToMany(targetEntity = User.class, mappedBy = "id_role", fetch = FetchType.LAZY)
  private List<User> users;

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getRole() {
    return role;
  }

  @Override
  public String toString() {
    return "Role{" +
      "id=" + id +
      ", role='" + role + '\'' +
      '}';
  }
}
