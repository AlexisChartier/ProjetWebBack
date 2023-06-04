package com.api.back.apiwebproject.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "produits")
@SecondaryTable(name = "magasins")
public class Produit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int produit_id;

    private String nom_produit;

    private double prix_produit;

    private String description_produit;

    private String imgsrc;

    @ManyToOne
    @JoinColumn(table = "magasins", referencedColumnName = "magasin_id")
    private Magasin magasin;

    public Produit() {
    }

    public Produit(int id, String nom, double prix, Magasin magasin, String description_produit, String imgsrc) {
        this.produit_id = id;
        this.nom_produit = nom;
        this.prix_produit = prix;
        this.magasin = magasin;
        this.description_produit = description_produit;
        this.imgsrc = imgsrc;
    }

    public String getDescription_produit() {
        return description_produit;
    }

    public void setDescription_produit(String description_produit) {
        this.description_produit = description_produit;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public int getProduit_id() {
        return produit_id;
    }

    public void setProduit_id(int id) {
        this.produit_id = id;
    }

    public String getNom_produit() {
        return nom_produit;
    }

    public void setNom_produit(String nom) {
        this.nom_produit = nom;
    }

    public double getPrix_produit() {
        return prix_produit;
    }

    public void setPrix_produit(double prix) {
        this.prix_produit = prix;
    }

    public Magasin getMagasin() {
        return magasin;
    }

    public void setMagasin(Magasin magasin) {
        this.magasin = magasin;
    }
}





