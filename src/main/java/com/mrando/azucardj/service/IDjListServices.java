package com.mrando.azucardj.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.mrando.azucardj.model.DjList;

@Service
public interface IDjListServices {
  List<DjList> fetch();
  void save(DjList djList);
  DjList searchById(Integer idDjList);
  List<DjList> searchByOwner(Integer idOwner);
}
