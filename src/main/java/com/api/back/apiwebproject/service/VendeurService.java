package com.api.back.apiwebproject.service;

import com.api.back.apiwebproject.model.Administrateur;
import com.api.back.apiwebproject.model.Vendeur;
import com.api.back.apiwebproject.repo.VendeurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendeurService {
    private final VendeurRepo vendeurRepo;

    @Autowired
    public VendeurService(VendeurRepo vendeurRepo) {
        this.vendeurRepo = vendeurRepo;
    }

    public Vendeur addVendeur(Vendeur vendeur) {
        return vendeurRepo.save(vendeur);
    }

    public Vendeur getVendeur(Long id) {
        return vendeurRepo.findById(id).orElse(null);
    }

    public Vendeur getVendeurByEmail(String email) {
        return vendeurRepo.findByEmail(email);
    }

    public Vendeur updateVendeur(Vendeur vendeur) {
        return vendeurRepo.save(vendeur);
    }

    public void deleteVendeur(Long id) {
        vendeurRepo.deleteById(id);
    }

    public List<Vendeur> getAll() {
        return vendeurRepo.findAll();
    }
}
