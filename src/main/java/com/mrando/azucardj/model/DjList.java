package com.mrando.azucardj.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Clase que representa una Djlist de reproducción de música. Contiene información sobre el nombre de la Djlist, su descripción, el usuario que la creó y las canciones que contiene.
public class DjList {

  private Integer id;
  private Integer idOwner;
  private LocalDateTime initDate;
  private List<Item> items;

  public DjList() {
    this.items = new ArrayList<>();
    this.initDate = LocalDateTime.now();
  }

  public DjList(Integer id, Integer idOwner) {
    this.id = id;
    this.idOwner = idOwner;
    this.initDate = LocalDateTime.now();
    this.items = new ArrayList<>();
  }

  public DjList getDjListaByI(Integer id) {
    return this;
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

  public List<Item> getItems() {
    return items;
  }

  public void addItem(Item item) {
    this.items.add(item);
  }

  public void removeItem(Item item) {
    this.items.remove(item);
  }
}
