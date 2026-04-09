package com.mrando.azucardj.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.OneToOne;

@Entity
@Table(name = "Artists")
public class Artist {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  // @OneToOne
  // @JoinColumn(name = "id_genre")
  private Integer genre;

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

  public void setGenre(Integer genre) {
    this.genre = genre;
  }

  public Integer getGenre() {
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
