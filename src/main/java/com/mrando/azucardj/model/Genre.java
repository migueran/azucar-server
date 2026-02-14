package com.mrando.azucardj.model;

public class Genre {
  private Integer id;
  private String nameGenre;

  public Genre(Integer id, String name) {
    this.id = id;
    this.nameGenre = name;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNameGenre() {
    return nameGenre;
  }

  public void setNameGenre(String nameGenre) {
    this.nameGenre = nameGenre;
  }

  public String toString() {
    return "Genre{" +
      "id=" + id +
      ", nameGenre='" + nameGenre + '\'' +
      '}';
  }
}
