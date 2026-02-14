package com.mrando.azucardj.model;

public class Artist {
  private Integer id;
  private String nameArtist;
  private Integer idGenre;

  public Artist(
    Integer id,
    String nameArtist,
    Integer idGenre
  ) {
    this.id = id;
    this.nameArtist = nameArtist;
    this.idGenre = idGenre;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNameArtist() {
    return nameArtist;
  }

  public void setNameArtist(String nameArtist) {
    this.nameArtist = nameArtist;
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
      ", nameArtist='" + nameArtist + '\'' +
      ", idGenre=" + idGenre +
      '}';
  }
}
