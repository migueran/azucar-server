package com.mrando.azucardj.model;

public class Artist {
  private Integer id;
  private String nameArtist;
  private Integer idGenre;

  public Artist gedArtistById(Integer id) {
    return this;
  }

  public String getNameArtist() {
    return nameArtist;
  }

  public void setNameArtist(String nameArtist) {
    this.nameArtist = nameArtist;
  }

  public void setGenero(Integer idGenre) {
    this.idGenre = idGenre;
  }
}
