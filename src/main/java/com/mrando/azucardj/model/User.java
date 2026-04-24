package com.mrando.azucardj.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
@EntityListeners(AuditingEntityListener.class)
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String username;
  private String password;
  private int status;
  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "UsersRoles",
    joinColumns = @JoinColumn(name = "id_user"),
    inverseJoinColumns = @JoinColumn(name = "id_role")
  )
	private List<Role> roles;
  @OneToOne(
    targetEntity = Profile.class
    //cascade = CascadeType.PERSIST
  )
  @JoinColumn(name = "id_profile", referencedColumnName = "id")
  private Profile profile;
  @CreatedDate
  @Column(name = "created_at",  updatable = false, columnDefinition = "TIMESTAMP")
  private LocalDateTime createdAt;
  @LastModifiedDate
  @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
  private LocalDateTime updatedAt;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public void setRole(List<Role> roles) {
    this.roles = roles;
  }

  public List<Role> getRole() {
    return roles;
  }

  public void setProfile(Profile profile) {
    this.profile = profile;
  }

  public Profile getProfile() {
    return profile;
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
      ", username='" + username + '\'' +
      ", password='" + password + '\'' +
      ", status=" + status +
      ", role=" + roles +
      ", created_at='" + createdAt + '\'' +
      ", updated_at='" + updatedAt + '\'' +
      '}';
  }

}


