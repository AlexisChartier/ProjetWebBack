package com.api.back.apiwebproject.service;

import com.api.back.apiwebproject.model.Administrateur;
import com.api.back.apiwebproject.model.Livreur;
import com.api.back.apiwebproject.repo.LivreurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivreurService {
    private final LivreurRepo livreurRepo;

    @Autowired
    public LivreurService(LivreurRepo livreurRepo) {
        this.livreurRepo = livreurRepo;
    }

    public Livreur addLivreur(Livreur livreur) {
        return livreurRepo.save(livreur);
    }

    public Livreur getLivreur(Long id) {
        return livreurRepo.findById(id).orElse(null);
    }

    public Livreur getLivreurByEmail(String email) {
        return livreurRepo.findByEmail(email);
    }

    public List<Livreur> getAll(){
        return livreurRepo.findAll();
    }

    public Livreur updateLivreur(Livreur livreur) {
        return livreurRepo.save(livreur);
    }

    public void deleteLivreur(Long id) {
        livreurRepo.deleteById(id);
    }
}
