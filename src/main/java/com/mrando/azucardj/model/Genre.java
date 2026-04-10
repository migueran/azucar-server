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
@Table(name = "Genres")
public class Genre {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  @ManyToMany(targetEntity = Artist.class, fetch = FetchType.LAZY)
  @JoinTable(name = "artist_genre", joinColumns = @JoinColumn(name = "id_genre"), inverseJoinColumns = @JoinColumn(name = "id_artist"))
  private List<Artist> artists;

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

  public void setArtists(List<Artist> artists) {
    this.artists = artists;
  }

  public List<Artist> getArtists() {
    return artists;
  }

  public String toString() {
    return "Genre{" +
      "id=" + id +
      ", name='" + name + '\'' +
      '}';
  }
}
