package com.mrando.azucardj.model;

public class Genre {
  private Integer id;
  private String nameGenre;

  public Genre(Integer id, String name) {
    this.id = id;
    this.nameGenre = name;
  }

  public Integer getIdGenre() {
    return this.id;
  }

  public String getNameGenre() {
    return this.nameGenre;
  }

  public void setNameGenre(String nameGenre) {
    this.nameGenre = nameGenre;
  }
}
