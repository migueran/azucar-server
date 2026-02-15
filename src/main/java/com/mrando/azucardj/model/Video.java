package com.mrando.azucardj.model;

public class Video {
  private Integer id;
  private String name;
  private String url;
  private Integer idGenre;

  public Video(
    Integer id,
    String name,
    String url,
    Integer idGenre
  ) {
    this.id = id;
    this.name = name;
    this.url = url;
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

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
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
      ", nameVideo='" + name + '\'' +
      ", url='" + url + '\'' +
      ", idGenre=" + idGenre +
      '}';
  }

}
