package com.mrando.azucardj.model;

public class Theme {
  private Integer id;
  private Integer idVideo;
  private String name;
  private String artist;
  private Integer idGenre;

  public Theme(
    Integer id,
    Integer idVideo,
    String name,
    String artist,
    Integer idGenre
  ) {
    this.id = id;
    this.idVideo = idVideo;
    this.name = name;
    this.artist = artist;
    this.idGenre = idGenre;
  }

  // Getters and Setters
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Theme getThemeById(Integer id) {
    return this;
  }

  public Integer getVideo() {
    return this.idVideo;
  }

  public void setUrl(Integer idVideo) {
    this.idVideo = idVideo;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getArtist() {
    return this.artist;
  }

  public void setArtist(String artist) {
    this.artist = artist;
  }

  public Integer getidGenre() {
    return this.idGenre;
  }

  public void setidGenre(Integer idGenre) {
    this.idGenre = idGenre;
  }

}
