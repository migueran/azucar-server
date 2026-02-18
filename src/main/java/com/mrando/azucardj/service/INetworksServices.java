package com.mrando.azucardj.service;

import java.util.List;
import com.mrando.azucardj.model.Network;

public interface INetworksServices {
  List<Network> fetch();
  void save(Network network);
  Network getById(Integer idNetwork);
  Network updateById(Integer idNetwork, Network network);
  void deleteById(Integer id);
  Network getByName(String name);
}
