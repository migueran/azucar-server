package com.mrando.azucardj.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

// Clase que representa una Djlist de reproducción de música. Contiene información sobre el nombre de la Djlist, su descripción, el usuario que la creó y las canciones que contiene.
@Entity
@Table(name = "DjLists")
public class DjList {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  @ManyToMany(targetEntity = User.class, fetch = FetchType.LAZY)
  @JoinTable(name = "djlist_owner", joinColumns = @JoinColumn(name = "id_djlist"), inverseJoinColumns = @JoinColumn(name = "id_owner"))
  private List<User> owner;
  @Column(name = "init_date")
  private LocalDateTime initDate;
  @OneToMany(targetEntity = Item.class, mappedBy = "items", cascade = CascadeType.PERSIST)
  private List<Item> items;

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

  public List<User> getidOwner() {
    return owner;
  }

  public void setidOwner(List<User> owner) {
    this.owner = owner;
  }

  public LocalDateTime getInitDate() {
    return initDate;
  }

  public List<Item> getItems() {
    return items;
  }

  public void addItem(Item idItem) {
    this.items.add(idItem);
  }

  public void removeItem(Item Item) {
    this.items.remove(Item); //mrando
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }

  public String toString() {
    return "DjList{" +
      "id=" + id +
      ", idOwner=" + owner +
      ", initDate=" + initDate +
      ", items=" + items +
      '}';
  }
}
