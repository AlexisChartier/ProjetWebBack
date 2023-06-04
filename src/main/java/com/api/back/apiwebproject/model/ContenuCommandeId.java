package com.api.back.apiwebproject.model;

import java.io.Serializable;

public class ContenuCommandeId implements Serializable {
    private Commande commande;

    private Produit produit;


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
}
