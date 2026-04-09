package com.mrando.azucardj.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Themes")
public class Theme {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  @OneToOne
  @JoinColumn(name = "id_video")
  private Video video;
  // @OneToOne
  // @JoinColumn(name = "id_artist")
  @Column(name = "id_artist")
  private Integer artist;
  // @OneToOne
  // @JoinColumn(name = "id_genre")
  private Integer genre;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getVideo() {
    return video.getId();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getArtist() {
    return artist;
  }

  public void setArtist(Integer idArtist) {
    this.artist = idArtist;
  }

  public Integer getGenre() {
    return genre;
  }

  public void setGenre(Integer idGenre) {
    this.genre = idGenre;
  }

  public String toString() {
    return "Theme{" +
      "id=" + id +
      ", idVideo=" + video.getId() +
      ", name='" + name + '\'' +
      ", idArtist=" + artist +
      ", idGenre=" + genre +
      '}';
  }

}
