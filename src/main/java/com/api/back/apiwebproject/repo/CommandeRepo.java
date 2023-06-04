package com.api.back.apiwebproject.repo;

import com.api.back.apiwebproject.model.Commande;
import com.api.back.apiwebproject.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommandeRepo extends JpaRepository<Commande, Long> {


    @Query(value = "SELECT C FROM Commande C where C.client.client_id=:id AND C.statutCommande=:statut")
    Commande findByClientId(@Param("id") Long id, @Param("statut") String statutcommande);

    @Query(value = "SELECT C FROM Commande C where C.livreur.livreur_id=:id and C.statutCommande=:statut")
    Commande findByLivreurId(@Param("id") Long id, @Param("statut") String statutcommande);

    @Query(value = "SELECT C FROM Commande C where C.client.client_id=:id")
    List<Commande> findAllByClientId(@Param("id") Long id);

    @Query(value = "SELECT C FROM Commande C where C.livreur.livreur_id=:id")
    List<Commande> findAllByLivreurId(@Param("id") Long id);
}
