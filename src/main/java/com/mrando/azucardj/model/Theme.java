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
  private int id;
  private String name;
  @OneToOne(targetEntity = Video.class, cascade = CascadeType.PERSIST)
  @JoinColumn(name = "id_video", referencedColumnName = "id")
  private Video video;
  @ManyToMany(targetEntity = Artist.class, fetch = FetchType.EAGER)
  @JoinTable(name = "theme_artist", joinColumns = @JoinColumn(name = "id_theme"), inverseJoinColumns = @JoinColumn(name = "id_artist"))
  private List<Artist> artist;
  @ManyToMany(targetEntity = Genre.class, fetch = FetchType.EAGER)
  @JoinTable(name = "theme_genre", joinColumns = @JoinColumn(name = "id_theme"), inverseJoinColumns = @JoinColumn(name = "id_genre"))
  private List<Genre> genre;

  public int getId() {
    return id;
  }

  public Video getVideo() {
    return video;
  }

  public String getName() {
    return name;
  }

  public List<Artist> getArtist() {
    return artist;
  }

  public List<Genre> getGenre() {
    return genre;
  }

  public Theme updateTheme(Theme theme) {
    if(theme.getName() != null)
      this.name = theme.getName();
    if(theme.getVideo() != null)
      this.video = theme.getVideo();
    if(theme.getArtist() != null && !theme.getArtist().isEmpty())
      this.artist = theme.getArtist();
    if(theme.getGenre() != null && !theme.getGenre().isEmpty())
      this.genre = theme.getGenre();
    return this;
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
