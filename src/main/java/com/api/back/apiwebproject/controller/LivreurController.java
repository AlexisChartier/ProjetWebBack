package com.api.back.apiwebproject.controller;

import com.api.back.apiwebproject.model.Administrateur;
import com.api.back.apiwebproject.model.Client;
import com.api.back.apiwebproject.model.Livreur;
import com.api.back.apiwebproject.service.LivreurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "/**")
@RestController
@RequestMapping("/livreurs")
public class LivreurController {
    private final LivreurService livreurService;

    @Autowired
    public LivreurController(LivreurService livreurService) {
        this.livreurService = livreurService;
    }

    @PostMapping("/post")
    public ResponseEntity<Livreur> addLivreur(@RequestBody Livreur livreur) {
        return new ResponseEntity<>(livreurService.addLivreur(livreur), HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Livreur> getLivreur(@PathVariable Long id) {
        Livreur livreur = livreurService.getLivreur(id);
        return livreur != null ? new ResponseEntity<>(livreur, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/get/email/{mail}")
    public ResponseEntity<Livreur> getLivreurByEmail(@PathVariable String mail) {
        Livreur livreur = livreurService.getLivreurByEmail(mail);
        return livreur != null ? new ResponseEntity<>(livreur, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Livreur>> getAllLivreur(){
        List<Livreur> livreurs = livreurService.getAll();
        return livreurs != null ? new ResponseEntity<>(livreurs, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update")
    public ResponseEntity<Livreur> updateLivreur(@RequestBody Livreur livreur) {
        return new ResponseEntity<>(livreurService.updateLivreur(livreur), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteLivreur(@PathVariable Long id) {
        livreurService.deleteLivreur(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
