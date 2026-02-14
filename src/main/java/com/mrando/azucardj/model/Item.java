package com.mrando.azucardj.model;

public class Item {
  private Integer id;
  //private
  public Integer initTime;
  //private
  public Integer endTime;
  //private
  public Integer idOwner;
  //private
  public Integer idTheme;

  public Item() {
  }
  public Item(
    Integer id,
    Integer initTime,
    Integer endTime,
    Integer idOwner,
    Integer idTheme
  ) {
    this.id = id;
    this.initTime = initTime;
    this.endTime = endTime;
    this.idOwner = idOwner;
    this.idTheme = idTheme;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getId(Integer id) {
    return this.id;
  }

  public Item getItemById(Integer id) {
    return this;
  }

  public void setInitTime(Integer initTime) {
    this.initTime = initTime;
  }

  public Integer getInitTime(Integer initTime) {
    return this.initTime;
  }

  public void setEndTime(Integer endTime) {
    this.endTime = endTime;
  }

  public Integer getEndTime(Integer endTime) {
    return this.endTime;
  }

  public Integer getidOwner() {
    return this.idOwner;
  }

  public void setidOwner(Integer idOwner) {
    this.idOwner = idOwner;
  }

  public Integer getidTheme() {
    return this.idTheme;
  }

  public void setidTheme(Integer idTheme) {
    this.idTheme = idTheme;
  }
}