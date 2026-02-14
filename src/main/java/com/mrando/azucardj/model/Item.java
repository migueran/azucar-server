package com.mrando.azucardj.model;

public class Item {
  private Integer id;
  private Integer initTime;
  private Integer endTime;
  private Integer idOwner;
  private Integer idTheme;

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

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setInitTime(Integer initTime) {
    this.initTime = initTime;
  }

  public Integer getInitTime(Integer initTime) {
    return initTime;
  }

  public void setEndTime(Integer endTime) {
    this.endTime = endTime;
  }

  public Integer getEndTime(Integer endTime) {
    return endTime;
  }

  public Integer getIdOwner() {
    return idOwner;
  }

  public void setidOwner(Integer idOwner) {
    this.idOwner = idOwner;
  }

  public Integer getIdTheme() {
    return idTheme;
  }

  public void setIdTheme(Integer idTheme) {
    this.idTheme = idTheme;
  }

  public String toString() {
    return "Item{" +
      "id=" + id +
      ", initTime=" + initTime +
      ", endTime=" + endTime +
      ", idOwner=" + idOwner +
      ", idTheme=" + idTheme +
      '}';
  }
}