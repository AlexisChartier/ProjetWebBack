package com.api.back.apiwebproject.controller;

import com.api.back.apiwebproject.model.Produit;
import com.api.back.apiwebproject.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/produit")
public class ProduitController {

    private final ProduitService produitService;

    @Autowired
    public ProduitController(ProduitService produitService){
        this.produitService = produitService;
    }

    @CrossOrigin
    @PostMapping("/post")
    public ResponseEntity<Produit> addProduit(@RequestBody Produit produit){
        Produit newProduit = produitService.addProduit(produit);
        return new ResponseEntity<>(newProduit, HttpStatus.CREATED);
    }

    @CrossOrigin
    @GetMapping("/get/byMagasin/{id}")
    public ResponseEntity<List<Produit>> findAllProduitByMagasinId(@PathVariable("id") Long id){
        List<Produit> produits = produitService.findAllProduitByMagasinId(id);
        return new ResponseEntity<>(produits, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/get/all")
    public ResponseEntity<List<Produit>> findAllProduit(){
        List<Produit> produits = produitService.findAllProduit();
        return new ResponseEntity<>(produits, HttpStatus.OK);
    }
    @CrossOrigin
    @PutMapping("/update")
    public ResponseEntity<Produit> updateProduit(@RequestBody Produit produit){
        Produit updatedProduit = produitService.updateProduit(produit);
        return new ResponseEntity<>(updatedProduit, HttpStatus.OK);
    }
    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduit(@PathVariable("id") Long id){
        produitService.deleteProduit(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
