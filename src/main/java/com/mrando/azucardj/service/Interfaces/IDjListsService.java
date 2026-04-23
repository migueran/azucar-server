package com.mrando.azucardj.service.Interfaces;

import java.util.List;

import org.springframework.stereotype.Service;
import com.mrando.azucardj.model.DjList;

@Service
public interface IDjListsService {
  List<DjList> fetch();
  void save(DjList djList);
  DjList findById(Integer idDjList);
  DjList findByName(String name);
  List<DjList> findByOwner(Integer idOwner);
}
