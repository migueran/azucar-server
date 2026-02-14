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

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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

  public String toString() {
    return "Video{" +
      "id=" + id +
      ", nameVideo='" + nameVideo + '\'' +
      ", urlVideo='" + urlVideo + '\'' +
      ", idGenre=" + idGenre +
      '}';
  }

}
