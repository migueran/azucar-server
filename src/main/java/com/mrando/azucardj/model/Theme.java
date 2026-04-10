package com.mrando.azucardj.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Themes")
public class Theme {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  @OneToOne(targetEntity = Video.class, mappedBy = "Themes", cascade = CascadeType.PERSIST)
  @JoinColumn(name = "id_video")
  private Video video;
  @ManyToMany(targetEntity = Artist.class, fetch = FetchType.EAGER)
  @JoinTable(name = "theme_artist", joinColumns = @JoinColumn(name = "id_theme"), inverseJoinColumns = @JoinColumn(name = "id_artist"))
  private List<Artist> artist;
  @ManyToMany(targetEntity = Genre.class, fetch = FetchType.EAGER)
  @JoinTable(name = "theme_genre", joinColumns = @JoinColumn(name = "id_theme"), inverseJoinColumns = @JoinColumn(name = "id_genre"))
  private List<Genre> genre;

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

  public List<Artist> getArtist() {
    return artist;
  }

  public void setArtist(List<Artist> artist) {
    this.artist = artist;
  }

  public List<Genre> getGenre() {
    return genre;
  }

  public void setGenre(List<Genre> genre) {
    this.genre = genre;
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
