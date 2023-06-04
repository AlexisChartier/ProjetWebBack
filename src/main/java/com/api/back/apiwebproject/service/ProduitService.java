package com.api.back.apiwebproject.service;

import com.api.back.apiwebproject.model.Produit;
import com.api.back.apiwebproject.repo.ProduitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {

    private final ProduitRepo produitRepo;

    @Autowired
    public ProduitService(ProduitRepo produitRepo){
        this.produitRepo = produitRepo;
    }

    public Produit addProduit(Produit produit){
        return produitRepo.save(produit);
    }

    public List<Produit> findAllProduitByMagasinId(Long id){
        return produitRepo.findAllByMagasinId(id);
    }

    public List<Produit> findAllProduit(){
        return produitRepo.findAll();
    }

    public Produit updateProduit(Produit produit){
        return produitRepo.save(produit);
    }

    public void deleteProduit(Long id){
        produitRepo.deleteById(id);
    }
}