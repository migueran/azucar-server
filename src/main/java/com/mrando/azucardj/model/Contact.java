package com.mrando.azucardj.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Contact {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private Integer idNetwork;
  private String url;

  // public Contact() {}

  // public Contact(Integer id, Integer idNetwork, String url) {
  //   this.id = id;
  //   this.idNetwork = idNetwork;
  //   this.url = url;
  // }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getIdNetwork() {
    return idNetwork;
  }

  public void setIdNetwork(Integer idNetwork) {
    this.idNetwork = idNetwork;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

}
