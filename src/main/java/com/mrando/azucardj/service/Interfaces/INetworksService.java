package com.mrando.azucardj.service.Interfaces;

import java.util.List;
import com.mrando.azucardj.model.Network;

public interface INetworksService {
  List<Network> fetch();
  void save(Network network);
  Network findById(Integer idNetwork);
  Network findByName(String name);
  Network update(Integer idNetwork, Network network);
  void delete(Integer id);
}
