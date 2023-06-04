package com.api.back.apiwebproject.controller;

import com.api.back.apiwebproject.model.ContenuCommande;
import com.api.back.apiwebproject.service.ContenuCommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/contenus_commande")
public class ContenuCommandeController {
    private final ContenuCommandeService contenuCommandeService;


    @Autowired
    public ContenuCommandeController(ContenuCommandeService contenuCommandeService) {
        this.contenuCommandeService = contenuCommandeService;
    }


    @CrossOrigin
    @PostMapping("/post")
    public ResponseEntity<ContenuCommande> addContenuCommande(@RequestBody ContenuCommande contenuCommande) {
        return new ResponseEntity<>(contenuCommandeService.addContenuCommande(contenuCommande), HttpStatus.CREATED);
    }
    @CrossOrigin
    @GetMapping("/get/{id}")
    public ResponseEntity<List<ContenuCommande>> getContenuCommande(@PathVariable Long id) {
        List<ContenuCommande> contenuCommande = contenuCommandeService.getContenuCommande(id);
        return contenuCommande != null ? new ResponseEntity<>(contenuCommande, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @CrossOrigin
    @PutMapping("/update")
    public ResponseEntity<ContenuCommande> updateContenuCommande(@RequestBody ContenuCommande contenuCommande) {
        return new ResponseEntity<>(contenuCommandeService.updateContenuCommande(contenuCommande), HttpStatus.OK);
    }
    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteContenuCommande(@PathVariable Long id) {
        contenuCommandeService.deleteContenuCommande(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
