package com.api.back.apiwebproject.service;

import com.api.back.apiwebproject.model.ContenuCommande;
import com.api.back.apiwebproject.repo.ContenuCommandeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContenuCommandeService {
    private final ContenuCommandeRepo contenuCommandeRepo;

    @Autowired
    public ContenuCommandeService(ContenuCommandeRepo contenuCommandeRepo) {
        this.contenuCommandeRepo = contenuCommandeRepo;
    }

    public ContenuCommande addContenuCommande(ContenuCommande contenuCommande) {
        return contenuCommandeRepo.save(contenuCommande);
    }

    public List<ContenuCommande> getContenuCommande(Long id) {
        return contenuCommandeRepo.findAllByCommandeId(id);
    }

    public ContenuCommande updateContenuCommande(ContenuCommande contenuCommande) {
        return contenuCommandeRepo.save(contenuCommande);
    }

    public void deleteContenuCommande(Long id) {
        contenuCommandeRepo.deleteById(id);
    }
}
