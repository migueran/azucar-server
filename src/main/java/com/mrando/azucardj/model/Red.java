package com.mrando.azucardj.model;

public class Red {
  private Integer id;
  private String nameRed;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNameRed() {
    return nameRed;
  }

  public void setNameRed(String nameRed) {
    this.nameRed = nameRed;
  }

  public Red(Integer id, String nameRed) {
    this.id = id;
    this.nameRed = nameRed;
  }

}
