package com.mrando.azucardj.model;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Artists")
public class Artist {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
  @ManyToMany(targetEntity = Genre.class, fetch = FetchType.EAGER)
  @JoinTable(name = "artist_genre", joinColumns = @JoinColumn(name = "id_artist"), inverseJoinColumns = @JoinColumn(name = "id_genre"))
  private List<Genre> genre;

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public List<Genre> getGenre() {
    return genre;
  }

  public Artist update(Artist artist) {
    this.name = artist.getName();
    this.genre = artist.getGenre();
    return this;
  }

  public String toString() {
    return "Artist{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", genre=" + genre +
      '}';
  }
}
