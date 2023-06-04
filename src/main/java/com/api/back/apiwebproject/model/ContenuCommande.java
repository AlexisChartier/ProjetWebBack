package com.api.back.apiwebproject.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "commande_produits")
@IdClass(ContenuCommandeId.class)
public class ContenuCommande implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToOne
    @JoinColumn(name = "id_commande")
    private Commande commande;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToOne
    @JoinColumn(name = "id_produit")
    private Produit produit;

    private int quantite;

    public ContenuCommande(){}

    public ContenuCommande(Commande commande, Produit produit, int quantite) {
        this.commande = commande;
        this.produit = produit;
        this.quantite = quantite;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}