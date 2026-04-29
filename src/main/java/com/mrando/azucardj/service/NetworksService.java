package com.mrando.azucardj.service;

import java.util.List;
import java.util.Optional;

import com.mrando.azucardj.model.Network;
import com.mrando.azucardj.repository.NetworksRepository;
import com.mrando.azucardj.service.Interfaces.INetworksService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NetworksService implements INetworksService {

   @Autowired
   private NetworksRepository repoNetworks;

   @Override
   public List<Network> fetch() {
      return (List<Network>) repoNetworks.findAll();
   }

   @Override
   public void save(Network network) {
        repoNetworks.save(network);
   }

   @Override
   public Network findById(Integer id) {
      Optional<Network> networkOptional = repoNetworks.findById(id);
      if (networkOptional.isPresent()) {
        return networkOptional.get();
      }
      return null;
   }

   @Override
   public Network update(Integer idNetwork, Network network) {
     repoNetworks.findById(idNetwork).ifPresent(existingNetwork -> {
       existingNetwork.setName(network.getName());
       System.err.println("Updating network with ID: " + existingNetwork);
        repoNetworks.save(existingNetwork);
    });
    return repoNetworks.findById(idNetwork).orElse(null);
  }

   @Override
   public void delete(Integer id) {
     repoNetworks.deleteById(id);
   }

   @Override
   public Network findByName(String name) {
    List<Network> networksList = (List<Network>) repoNetworks.findAll();
    for (Network network : networksList) {
        if (network.getName().toLowerCase().equals(name.replace("-", " ").toLowerCase())) {
            return network;
        }
    }
    return null;
   }

}
