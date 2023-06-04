package com.api.back.apiwebproject.service;

import com.api.back.apiwebproject.model.Administrateur;
import com.api.back.apiwebproject.repo.AdministrateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministrateurService {
    private final AdministrateurRepo administrateurRepo;

    @Autowired
    public AdministrateurService(AdministrateurRepo administrateurRepo) {
        this.administrateurRepo = administrateurRepo;
    }

    public Administrateur addAdministrateur(Administrateur administrateur) {
        return administrateurRepo.save(administrateur);
    }

    public Administrateur getAdministrateur(Long id) {
        return administrateurRepo.findById(id).orElse(null);
    }
    public Administrateur getAdministrateurByEmail(String email) {
        return administrateurRepo.findByEmail(email);
    }

    public Administrateur updateAdministrateur(Administrateur administrateur) {
        return administrateurRepo.save(administrateur);
    }

    public void deleteAdministrateur(Long id) {
        administrateurRepo.deleteById(id);
    }
}
