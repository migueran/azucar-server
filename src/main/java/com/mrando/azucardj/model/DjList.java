package com.mrando.azucardj.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Clase que representa una Djlist de reproducción de música. Contiene información sobre el nombre de la Djlist, su descripción, el usuario que la creó y las canciones que contiene.
public class DjList {

  private Integer id;
  private Integer idOwner;
  private LocalDateTime initDate;
  private List<Integer> items;

  public DjList(Integer id, Integer idOwner, ArrayList<Integer> idItems) {
    this.id = id;
    this.idOwner = idOwner;
    this.initDate = LocalDateTime.now();
    this.items = idItems;
  }

  public Integer getId(Integer id) {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getidOwner() {
    return idOwner;
  }

  public void setidOwner(Integer idOwner) {
    this.idOwner = idOwner;
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
      ", idOwner=" + idOwner +
      ", initDate=" + initDate +
      ", items=" + items +
      '}';
  }
}
