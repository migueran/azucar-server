package com.mrando.azucardj.service.Interfaces;

import com.mrando.azucardj.model.Profile;

public interface IProfilesService {
    Profile save(Profile profile);
    Profile findById(int id);
    Profile findByEmail(String email);
    Profile update(Profile profile);
    void delete(int id);
}
