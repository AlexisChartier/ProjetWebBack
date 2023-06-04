package com.api.back.apiwebproject.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "livreurs")
@SecondaryTable(name = "commandes")
public class Livreur  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false,updatable = false)
    private int livreur_id;

    private String nom_livreur;

    private String prenom_livreur;

    private String adresse_livreur;

    private String email;

    private String mot_de_passe;

    private String role;

    @OneToMany(mappedBy = "livreur", cascade = CascadeType.ALL)
    private List<Commande> commandes;

    public Livreur(){}

    public Livreur(int livreur_id, String nom_livreur, String prenom_livreur, String adresse_livreur, String email, String mot_de_passe, String role, List<Commande> commandes) {
        this.livreur_id = livreur_id;
        this.nom_livreur = nom_livreur;
        this.prenom_livreur = prenom_livreur;
        this.adresse_livreur = adresse_livreur;
        this.email = email;
        this.mot_de_passe = mot_de_passe;
        this.role = role;
        this.commandes = commandes;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public int getLivreur_id() {
        return livreur_id;
    }

    public void setLivreur_id(int livreur_id) {
        this.livreur_id = livreur_id;
    }

    public String getNom_livreur() {
        return nom_livreur;
    }

    public void setNom_livreur(String nomLivreur) {
        this.nom_livreur = nomLivreur;
    }

    public String getPrenom_livreur() {
        return prenom_livreur;
    }

    public void setPrenom_livreur(String prenomLivreur) {
        this.prenom_livreur = prenomLivreur;
    }

    public String getAdresse_livreur() {
        return adresse_livreur;
    }

    public void setAdresse_livreur(String adresseLivreur) {
        this.adresse_livreur = adresseLivreur;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }
}