package com.mrando.azucardj.model;

import java.time.LocalDateTime;

public class Item {
  private Integer id;
  private LocalDateTime initTime;
  private LocalDateTime endTime;
  private Integer idAuthor;
  private Integer idTheme;

  public Item(Integer id, LocalDateTime initTime, LocalDateTime endTime, Integer idAuthor, Integer idTheme) {
    this.id = id;
    this.initTime = initTime;
    this.endTime = endTime;
    this.idAuthor = idAuthor;
    this.idTheme = idTheme;
  }

  public Item getItemById(Integer id) {
    return this;
  }

  public void setInitTime(LocalDateTime initTime) {
    this.initTime = initTime;
  }

  public void setEndTime(LocalDateTime endTime) {
    this.endTime = endTime;
  }

  public Integer getidAuthor() {
    return idAuthor;
  }

  public void setidAuthor(Integer idAuthor) {
    this.idAuthor = idAuthor;
  }

  public Integer getidTheme() {
    return idTheme;
  }

  public void setidTheme(Integer idTheme) {
    this.idTheme = idTheme;
  }
}