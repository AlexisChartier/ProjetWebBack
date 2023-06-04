package com.api.back.apiwebproject.controller;

import com.api.back.apiwebproject.model.Administrateur;
import com.api.back.apiwebproject.model.Client;
import com.api.back.apiwebproject.model.Vendeur;
import com.api.back.apiwebproject.service.VendeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/vendeurs")
public class VendeurController {
    private final VendeurService vendeurService;

    @Autowired
    public VendeurController(VendeurService vendeurService) {
        this.vendeurService = vendeurService;
    }

    @CrossOrigin
    @PostMapping("/post")
    public ResponseEntity<Vendeur> addVendeur(@RequestBody Vendeur vendeur) {
        return new ResponseEntity<>(vendeurService.addVendeur(vendeur), HttpStatus.CREATED);
    }
    @CrossOrigin
    @GetMapping("/get/{id}")
    public ResponseEntity<Vendeur> getVendeur(@PathVariable Long id) {
        Vendeur vendeur = vendeurService.getVendeur(id);
        return vendeur != null ? new ResponseEntity<>(vendeur, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @CrossOrigin
    @GetMapping("/get/email/{mail}")
    public ResponseEntity<Vendeur> getVendeurByEmail(@PathVariable String mail) {
        Vendeur vendeur = vendeurService.getVendeurByEmail(mail);
        return vendeur != null ? new ResponseEntity<>(vendeur, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @CrossOrigin
    @GetMapping("/get/all")
    public ResponseEntity<List<Vendeur>> getAllVendeur(){
        List<Vendeur> vendeurs = vendeurService.getAll();
        return vendeurs != null ? new ResponseEntity<>(vendeurs, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @CrossOrigin
    @PutMapping("/update")
    public ResponseEntity<Vendeur> updateVendeur(@RequestBody Vendeur vendeur) {
        return new ResponseEntity<>(vendeurService.updateVendeur(vendeur), HttpStatus.OK);
    }
    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteVendeur(@PathVariable Long id) {
        vendeurService.deleteVendeur(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
