package com.mrando.azucardj.service;

import java.util.List;
import java.util.Optional;

import com.mrando.azucardj.model.Network;
import com.mrando.azucardj.repository.NetworksRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NetworksServices implements INetworksServices {

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
   public Network getById(Integer id) {
      Optional<Network> networkOptional = repoNetworks.findById(id);
      if (networkOptional.isPresent()) {
        return networkOptional.get();
    }
    return null;
   }

   @Override
   public Network updateById(Integer idNetwork, Network network) {
    Optional<Network> networkOptional = repoNetworks.findById(idNetwork);
    if (networkOptional.isPresent()) {
        Network existingNetwork = networkOptional.get();
        existingNetwork.setName(network.getName());
        return repoNetworks.save(existingNetwork);
    }
    return null;
   }

   @Override
   public void deleteById(Integer id) {
     repoNetworks.deleteById(id);
   }

   @Override
   public Network getByName(String name) {
    List<Network> networksList = (List<Network>) repoNetworks.findAll();
    for (Network network : networksList) {
        if (network.getName().toLowerCase().equals(name.replace("-", " ").toLowerCase())) {
            return network;
        }
    }
    return null;
   }

}
