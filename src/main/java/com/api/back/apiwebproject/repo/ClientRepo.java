package com.api.back.apiwebproject.repo;

import com.api.back.apiwebproject.model.Administrateur;
import com.api.back.apiwebproject.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepo extends JpaRepository<Client, Long> {

    @Query(value = "SELECT C FROM Client C where C.email=:mail")
    Client findByEmail(@Param("mail") String mail);
}
