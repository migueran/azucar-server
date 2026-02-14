package com.mrando.azucardj.model;

public class Theme {
  private Integer id;
  private Integer idVideo;
  private String name;
  private Integer idArtist;
  private Integer idGenre;

  public Theme(
    Integer id,
    Integer idVideo,
    String name,
    Integer idArtist,
    Integer idGenre
  ) {
    this.id = id;
    this.idVideo = idVideo;
    this.name = name;
    this.idArtist = idArtist;
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

  public Integer getArtist() {
    return this.idArtist;
  }

  public void setArtist(Integer idArtist) {
    this.idArtist = idArtist;
  }

  public Integer getidGenre() {
    return this.idGenre;
  }

  public void setidGenre(Integer idGenre) {
    this.idGenre = idGenre;
  }

}
