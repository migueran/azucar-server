package com.mrando.azucardj.model;

public class Genre {
  private Integer id;
  private String nameGenre;

  public Genre getGenreById(Integer id) {
    return this;
  }

  public String getNameGenre() {
    return nameGenre;
  }

  public void setNameGenre(String nameGenre) {
    this.nameGenre = nameGenre;
  }
}
