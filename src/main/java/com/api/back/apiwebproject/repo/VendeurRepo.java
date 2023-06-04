package com.api.back.apiwebproject.repo;

import com.api.back.apiwebproject.model.Administrateur;
import com.api.back.apiwebproject.model.Vendeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VendeurRepo extends JpaRepository<Vendeur, Long> {
    @Query(value = "SELECT V FROM Vendeur V where V.email=:mail")
    Vendeur findByEmail(@Param("mail") String mail);
}
