package com.mrando.azucardj.model;

public class Video {
  private Integer id;
  private String nameVideo;
  private String urlVideo;
  private Integer idGenre;
  private Red red;

  public Video getVideoById(Integer id) {
    return this;
  }

  public String getNameVideo() {
    return nameVideo;
  }

  public void setNameVideo(String nameVideo) {
    this.nameVideo = nameVideo;
  }

  public String getUrlVideo() {
    return urlVideo;
  }

  public void setUrlVideo(String urlVideo) {
    this.urlVideo = urlVideo;
  }

  public Integer getGenre() {
    return idGenre;
  }

  public void setGenre(Integer idGenre) {
    this.idGenre = idGenre;
  }

  public Red getRed() {
    return red;
  }

  public void setRed(Red red) {
    this.red = red;
  }

}
