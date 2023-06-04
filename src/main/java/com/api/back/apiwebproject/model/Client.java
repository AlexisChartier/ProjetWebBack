package com.api.back.apiwebproject.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "clients")
@SecondaryTable(name = "commandes")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false,updatable = false)
    private int client_id;

    private String nom_client;

    private String prenom_client;

    private String adresse_client;

    private String email;

    private String mot_de_passe;

    private String role;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Commande> commandes;

    public Client(){}

    public Client(int client_id, String nom_client, String prenom_client, String adresse_client, String email, String mot_de_passe, String role, List<Commande> commandes) {
        this.client_id = client_id;
        this.nom_client = nom_client;
        this.prenom_client = prenom_client;
        this.adresse_client = adresse_client;
        this.email = email;
        this.mot_de_passe = mot_de_passe;
        this.role = role;
        this.commandes = commandes;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public void setNom_client(String nom_client) {
        this.nom_client = nom_client;
    }

    public void setPrenom_client(String prenom_client) {
        this.prenom_client = prenom_client;
    }

    public void setAdresse_client(String adresse_client) {
        this.adresse_client = adresse_client;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    public int getClient_id() {
        return client_id;
    }

    public String getNom_client() {
        return nom_client;
    }

    public String getPrenom_client() {
        return prenom_client;
    }

    public String getAdresse_client() {
        return adresse_client;
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

    public List<Commande> getCommandes() {
        return commandes;
    }
}