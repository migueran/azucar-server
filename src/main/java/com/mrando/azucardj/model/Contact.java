package com.mrando.azucardj.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Contacts")
public class Contact {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @ManyToOne(targetEntity = Network.class)
  @JoinColumn(name = "network_id")
  private Network network;
  private String url;
  @ManyToOne(targetEntity = Profile.class )
  @JsonBackReference
  @JoinColumn(name = "profile_id")
  private Profile profile;

  public int getId() {
    return id;
  }

  public Network getNetwork() {
    return network;
  }

  public String getUrl() {
    return url;
  }

  public void setProfile(Profile profile) {
    this.profile = profile;
  }

  public Profile getProfile() {
    return profile;
  }

  public Contact update(Network newNetwork, String newUrl) {
    if(newNetwork != null)
      this.network = newNetwork;
    if(newUrl != null)
      this.url = newUrl;
    return this;
  }

}
