package com.api.back.apiwebproject.repo;

import com.api.back.apiwebproject.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProduitRepo extends JpaRepository<Produit, Long> {
    @Query(value = "SELECT P FROM Produit P where P.magasin.magasin_id=:id")
    List<Produit> findAllByMagasinId(@Param("id") Long id);
}
