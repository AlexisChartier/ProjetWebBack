package com.api.back.apiwebproject.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "magasins")
@SecondaryTable(name = "produits", pkJoinColumns = @PrimaryKeyJoinColumn(name = "magasin_id"))
@SecondaryTable(name = "vendeurs", pkJoinColumns = @PrimaryKeyJoinColumn(name = "magasin_id"))
public class Magasin  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "magasin_id")
    private int magasin_id;

    private String nom_magasin;

    private String adresse_magasin;

    private String imgsrc;

    private String description;

    @OneToMany(mappedBy = "magasin", cascade = CascadeType.ALL)
    private List<Produit> produits;

    @OneToMany(mappedBy = "magasin", cascade = CascadeType.ALL)
    private List<Commande> commandes;

    public Magasin() {

    }

    public Magasin(int magasin_id, String nom_magasin, String adresse_magasin, List<Produit> produits, List<Commande> commandes, String imgsrc, String description) {
        this.magasin_id = magasin_id;
        this.nom_magasin = nom_magasin;
        this.adresse_magasin = adresse_magasin;
        this.produits = produits;
        this.commandes = commandes;
        this.imgsrc = imgsrc;
        this.description = description;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMagasin_id() {
        return magasin_id;
    }

    public void setMagasin_id(int magasin_id) {
        this.magasin_id = magasin_id;
    }

    public String getNom_magasin() {
        return nom_magasin;
    }

    public void setNom_magasin(String nomMagasin) {
        this.nom_magasin = nomMagasin;
    }

    public String getAdresse_magasin() {
        return adresse_magasin;
    }

    public void setAdresse_magasin(String adresseMagasin) {
        this.adresse_magasin = adresseMagasin;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }
}