package com.mrando.azucardj.model;

public class Artist {
  private Integer id;
  private String name;
  private Integer idGenre;

  public Artist(
    Integer id,
    String name,
    Integer idGenre
  ) {
    this.id = id;
    this.name = name;
    this.idGenre = idGenre;
  }

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

  public void setGenre(Integer idGenre) {
    this.idGenre = idGenre;
  }

  public Integer getGenre() {
    return idGenre;
  }

  public String toString() {
    return "Artist{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", idGenre=" + idGenre +
      '}';
  }
}
