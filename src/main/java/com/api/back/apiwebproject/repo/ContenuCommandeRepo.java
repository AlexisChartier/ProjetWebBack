package com.api.back.apiwebproject.repo;

import com.api.back.apiwebproject.model.ContenuCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContenuCommandeRepo extends JpaRepository<ContenuCommande, Long> {
    @Query(value = "SELECT C FROM ContenuCommande C WHERE C.commande.commande_id=:id")
    List<ContenuCommande> findAllByCommandeId(@Param("id") long id);
}
