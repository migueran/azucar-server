package com.mrando.azucardj.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Videos")
public class Video {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
  private String url;

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getUrl() {
    return url;
  }

  public Video update(Video video) {
    this.name = video.getName();
    this.url = video.getUrl();
    return this;
  }

  public String toString() {
    return "Video{" +
      "id=" + id +
      ", nameVideo='" + name + '\'' +
      ", url='" + url + '\'' +
      '}';
  }

}
