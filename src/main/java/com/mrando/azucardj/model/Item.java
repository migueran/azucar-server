package com.mrando.azucardj.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Items")
public class Item {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(name = "init_time")
  private Integer initTime;
  @Column(name = "end_time")
  private Integer endTime;
  @ManyToMany(targetEntity = User.class, fetch = FetchType.EAGER)
  @JoinTable(name = "item_owner", joinColumns = @JoinColumn(name = "id_owner"), inverseJoinColumns = @JoinColumn(name = "id_artist"))
  private List<User> owner;
  @OneToOne(targetEntity = Theme.class, cascade = CascadeType.PERSIST)
  @JoinColumn(name = "id_theme")
  private Integer theme;
  @ManyToOne(targetEntity = DjList.class)
  private DjList djLists;

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

  public List<User> getIdOwner() {
    return owner;
  }

  public void setidOwner(List<User> owner) {
    this.owner = owner;
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