package com.mrando.azucardj.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Items")
public class Item {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(name = "init_time")
  private Integer initTime; //LocalDate
  @Column(name = "end_time")
  private Integer endTime; //LocalDate
  // @OneToOne
  // @JoinColumn(name = "id_owner")
  private Integer owner;
  // @OneToOne
  // @JoinColumn(name = "id_theme")
  private Integer theme;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setInitTime(Integer initTime) {
    this.initTime = initTime;
  }

  public Integer getInitTime(Integer initTime) {
    return initTime;
  }

  public void setEndTime(Integer endTime) {
    this.endTime = endTime;
  }

  public Integer getEndTime(Integer endTime) {
    return endTime;
  }

  public Integer getIdOwner() {
    return owner;
  }

  public void setidOwner(Integer idOwner) {
    this.owner = idOwner;
  }

  public Integer getIdTheme() {
    return theme;
  }

  public void setIdTheme(Integer idTheme) {
    this.theme = idTheme;
  }

  public String toString() {
    return "Item{" +
      "id=" + id +
      ", initTime=" + initTime +
      ", endTime=" + endTime +
      ", idOwner=" + owner +
      ", idTheme=" + theme +
      '}';
  }
}