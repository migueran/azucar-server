package com.mrando.azucardj.model;

public class Video {
  private Integer id;
  private String nameVideo;
  private String urlVideo;
  private Integer idGenre;

  public Video(
    Integer id,
    String nameVideo,
    String urlVideo,
    Integer idGenre
  ) {
    this.id = id;
    this.nameVideo = nameVideo;
    this.urlVideo = urlVideo;
    this.idGenre = idGenre;
  }

  public Video getVideoById(Integer id) {
    return this;
  }

  public String getNameVideo() {
    return this.nameVideo;
  }

  public void setNameVideo(String nameVideo) {
    this.nameVideo = nameVideo;
  }

  public String getUrlVideo() {
    return this.urlVideo;
  }

  public void setUrlVideo(String urlVideo) {
    this.urlVideo = urlVideo;
  }

  public Integer getGenre() {
    return this.idGenre;
  }

  public void setGenre(Integer idGenre) {
    this.idGenre = idGenre;
  }

}
