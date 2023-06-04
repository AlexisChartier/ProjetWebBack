package com.api.back.apiwebproject.controller;

import com.api.back.apiwebproject.model.Administrateur;
import com.api.back.apiwebproject.service.AdministrateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@CrossOrigin
@RestController
@RequestMapping("/administrateurs")
public class AdministrateurController {

    private final AdministrateurService administrateurService;

    @Autowired
    public AdministrateurController(AdministrateurService administrateurService) {
        this.administrateurService = administrateurService;
    }

    @CrossOrigin
    @PostMapping("/post")
    public ResponseEntity<Administrateur> addAdministrateur(@RequestBody Administrateur administrateur) {
        return new ResponseEntity<>(administrateurService.addAdministrateur(administrateur), HttpStatus.CREATED);
    }
    @CrossOrigin
    @GetMapping("/get/{id}")
    public ResponseEntity<Administrateur> getAdministrateur(@PathVariable Long id) {
        Administrateur administrateur = administrateurService.getAdministrateur(id);
        return administrateur != null ? new ResponseEntity<>(administrateur, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @CrossOrigin
    @GetMapping("/get/email/{mail}")
    public ResponseEntity<Administrateur> getAdministrateurByEmail(@PathVariable String mail) {
        Administrateur administrateur = administrateurService.getAdministrateurByEmail(mail);
        return administrateur != null ? new ResponseEntity<>(administrateur, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @CrossOrigin
    @PutMapping("/update")
    public ResponseEntity<Administrateur> updateAdministrateur(@RequestBody Administrateur administrateur) {
        return new ResponseEntity<>(administrateurService.updateAdministrateur(administrateur), HttpStatus.OK);
    }
    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAdministrateur(@PathVariable Long id) {
        administrateurService.deleteAdministrateur(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
