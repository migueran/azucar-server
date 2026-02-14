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

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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

  public Integer getArtist() {
    return idArtist;
  }

  public void setArtist(Integer idArtist) {
    this.idArtist = idArtist;
  }

  public Integer getGenre() {
    return idGenre;
  }

  public void setGenre(Integer idGenre) {
    this.idGenre = idGenre;
  }

  public String toString() {
    return "Theme{" +
      "id=" + id +
      ", idVideo=" + idVideo +
      ", name='" + name + '\'' +
      ", idArtist=" + idArtist +
      ", idGenre=" + idGenre +
      '}';
  }

}
