package com.mrando.azucardj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mrando.azucardj.model.Profile;
import com.mrando.azucardj.repository.ProfileRepository;
import com.mrando.azucardj.service.Interfaces.IProfilesService;

@Service
public class ProfilesService implements IProfilesService {

  @Autowired
  private ProfileRepository profileRepository;

  @Override
  public Profile save(Profile profile) {
    return profileRepository.save(profile);
  }

  @Override
  public Profile findById(int id) {
    return profileRepository.findById(id).orElse(null);
  }

  @Override
  public Profile findByEmail(String email) {
    return profileRepository.findAll().stream()
        .filter(profile -> profile.getEmail().equals(email))
        .findFirst()
        .orElse(null);
  }

  @Override
  public Profile update(Profile profile) {
    return profileRepository.save(profile);
  }

  @Override
  public void delete(int id) {
    profileRepository.deleteById(id);
  }

}
