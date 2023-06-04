package com.api.back.apiwebproject.service;

import com.api.back.apiwebproject.model.Commande;
import com.api.back.apiwebproject.repo.CommandeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService {
    private final CommandeRepo commandeRepo;

    @Autowired
    public CommandeService(CommandeRepo commandeRepo) {
        this.commandeRepo = commandeRepo;
    }

    public Commande addCommande(Commande commande) {
        return commandeRepo.save(commande);
    }

    public Commande getCommande(Long id) {
        return commandeRepo.findById(id).orElse(null);
    }

    public Commande getCommandeEnCoursByClient(Long id){
        return commandeRepo.findByClientId(id,"en cours");
    }

    public Commande getCommandeEnCoursByLivreur(Long id){
        return commandeRepo.findByLivreurId(id, "en cours");
    }

    public List<Commande> getCommandeByClient(Long id){
        return commandeRepo.findAllByClientId(id);
    }

    public List<Commande> getCommandeByLivreur(Long id){
        return commandeRepo.findAllByLivreurId(id);
    }
    public Commande updateCommande(Commande commande) {
        return commandeRepo.save(commande);
    }

    public void deleteCommande(Long id) {
        commandeRepo.deleteById(id);
    }
}
