package com.api.back.apiwebproject.repo;

import com.api.back.apiwebproject.model.Administrateur;
import com.api.back.apiwebproject.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdministrateurRepo extends JpaRepository<Administrateur, Long> {

    @Query(value = "SELECT A FROM Administrateur A where A.mail_admin=:mail")
    Administrateur findByEmail(@Param("mail") String mail);
}
