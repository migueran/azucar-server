package com.mrando.azucardj.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

// Clase que representa una Djlist de reproducción de música. Contiene información sobre el nombre de la Djlist, su descripción, el usuario que la creó y las canciones que contiene.
@Entity
@Table(name = "DjLists")
public class DjList {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  // @OneToOne
  // @JoinColumn(name = "id_owner")
  private Integer owner;
  @Column(name = "init_date")
  private LocalDateTime initDate;
  private List<Integer> items;

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

  public Integer getidOwner() {
    return owner;
  }

  public void setidOwner(Integer owner) {
    this.owner = owner;
  }

  public LocalDateTime getInitDate() {
    return initDate;
  }

  public List<Integer> getItems() {
    return items;
  }

  public void addItem(Integer idItem) {
    this.items.add(idItem);
  }

  public void removeItem(Integer idItem) {
    this.items.remove(idItem);
  }

  public void setItems(List<Integer> items) {
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
