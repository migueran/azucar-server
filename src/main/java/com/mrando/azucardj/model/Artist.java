package com.mrando.azucardj.model;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

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
  private Integer id;
  private String name;
  @ManyToMany(targetEntity = Genre.class, fetch = FetchType.EAGER)
  @JoinTable(name = "artist_genre", joinColumns = @JoinColumn(name = "id_artist"), inverseJoinColumns = @JoinColumn(name = "id_genre"))
  private List<Genre> genre;

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

  public void setGenre(List<Genre> genre) {
    this.genre = genre;
  }

  public List<Genre> getGenre() {
    return genre;
  }

  public String toString() {
    return "Artist{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", idGenre=" + genre +
      '}';
  }
}
