package com.mrando.azucardj.service;

import java.util.List;
import com.mrando.azucardj.model.DjList;

public interface IDjListServices {
  List<DjList> fetch();
  void save(DjList djList);
  DjList searchById(Integer idDjList);
  List<DjList> searchByOwner(Integer idOwner);
  List<DjList> searchByGenre(Integer idGenre);
}
