package com.api.back.apiwebproject.model;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "vendeurs")
@SecondaryTable(name = "magasins")
public class Vendeur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false,updatable = false)
    private int vendeur_id;

    private String nom_vendeur;

    private String prenom_vendeur;

    private String email;

    private String adresse_vendeur;

    private String mot_de_passe;

    private String role;

    @ManyToOne
    @JoinColumn(table = "magasins", referencedColumnName = "magasin_id")
    private Magasin magasin;

    public Vendeur() {}


    public Vendeur(int vendeur_id, String nom_vendeur, String prenom_vendeur, String email, String adresse_vendeur, String mot_de_passe, String role, Magasin magasin) {
        this.vendeur_id = vendeur_id;
        this.nom_vendeur = nom_vendeur;
        this.prenom_vendeur = prenom_vendeur;
        this.email = email;
        this.adresse_vendeur = adresse_vendeur;
        this.mot_de_passe = mot_de_passe;
        this.role = role;
        this.magasin = magasin;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNom_vendeur() {
        return nom_vendeur;
    }

    public void setNom_vendeur(String nom_vendeur) {
        this.nom_vendeur = nom_vendeur;
    }

    public String getPrenom_vendeur() {
        return prenom_vendeur;
    }

    public void setPrenom_vendeur(String prenom_vendeur) {
        this.prenom_vendeur = prenom_vendeur;
    }

    public String getAdresse_vendeur() {
        return adresse_vendeur;
    }

    public void setAdresse_vendeur(String adresse_vendeur) {
        this.adresse_vendeur = adresse_vendeur;
    }

    public Magasin getMagasin() {
        return magasin;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public int getVendeur_id() {
        return vendeur_id;
    }

    public void setVendeur_id(int vendeur_id) {
        this.vendeur_id = vendeur_id;
    }

    public void setMagasin(Magasin magasin) {
        this.magasin = magasin;
    }
}