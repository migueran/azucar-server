package com.mrando.azucardj.model;

public class Theme {
  private Integer id;
  private Integer idVideo;
  private String name;
  private String artist;
  private Integer idGenre;

  // Getters and Setters
  public Theme getThemeById(Integer id) {
    return this;
  }

  public Integer getVideo() {
    return idVideo;
  }

  public void setUrl(Integer idVideo) {
    this.idVideo = idVideo;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getArtist() {
    return artist;
  }

  public void setArtist(String artist) {
    this.artist = artist;
  }

  public Integer getidGenre() {
    return idGenre;
  }

  public void setidGenre(Integer idGenre) {
    this.idGenre = idGenre;
  }

}
