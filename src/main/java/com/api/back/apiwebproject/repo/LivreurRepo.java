package com.api.back.apiwebproject.repo;

import com.api.back.apiwebproject.model.Administrateur;
import com.api.back.apiwebproject.model.Livreur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LivreurRepo extends JpaRepository<Livreur, Long> {
    @Query(value = "SELECT L FROM Livreur L where L.email=:mail")
    Livreur findByEmail(@Param("mail") String mail);
}
