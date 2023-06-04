package com.api.back.apiwebproject.controller;

import com.api.back.apiwebproject.model.Commande;
import com.api.back.apiwebproject.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/commandes")
public class CommandeController {
    private final CommandeService commandeService;

    @Autowired
    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @CrossOrigin
    @PostMapping("/post")
    public ResponseEntity<Commande> addCommande(@RequestBody Commande commande) {
        return new ResponseEntity<>(commandeService.addCommande(commande), HttpStatus.CREATED);
    }
    @CrossOrigin
    @GetMapping("get/encours/livreur/{id}")
    public ResponseEntity<Commande> getCommandeByLivreurId(@PathVariable Long id) {
        Commande commande = commandeService.getCommandeEnCoursByLivreur(id);
        return commande != null ? new ResponseEntity<>(commande, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @CrossOrigin
    @GetMapping("get/encours/client/{id}")
    public ResponseEntity<Commande> getCommandeByClientId(@PathVariable Long id) {
        Commande commande = commandeService.getCommandeEnCoursByClient(id);
        return commande != null ? new ResponseEntity<>(commande, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @CrossOrigin
    @GetMapping("get/all/client/{id}")
    public ResponseEntity<List<Commande>> getCommandesByClientId(@PathVariable Long id) {
        List<Commande> commandes = commandeService.getCommandeByClient(id);
        return commandes != null ? new ResponseEntity<>(commandes, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @CrossOrigin
    @GetMapping("get/all/livreur/{id}")
    public ResponseEntity<List<Commande>> getCommandesByLivreurId(@PathVariable Long id) {
        List<Commande> commandes = commandeService.getCommandeByLivreur(id);
        return commandes != null ? new ResponseEntity<>(commandes, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @CrossOrigin
    @PutMapping("/update")
    public ResponseEntity<Commande> updateCommande(@RequestBody Commande commande) {
        return new ResponseEntity<>(commandeService.updateCommande(commande), HttpStatus.OK);
    }
    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCommande(@PathVariable Long id) {
        commandeService.deleteCommande(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
