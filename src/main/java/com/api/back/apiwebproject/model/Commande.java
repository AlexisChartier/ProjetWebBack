package com.api.back.apiwebproject.model;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "commandes")
@SecondaryTable(name = "clients")
@SecondaryTable(name = "livreurs")
@SecondaryTable(name = "magasins")
public class Commande implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commande_id;

    @ManyToOne
    @JoinColumn(table = "clients", referencedColumnName = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(table = "livreurs" , referencedColumnName = "livreur_id")
    private Livreur livreur;

    @ManyToOne
    @JoinColumn(table = "magasins", referencedColumnName = "magasin_id")
    private Magasin magasin;

    private Date dateCommande;

    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL)
    private List<ContenuCommande> contenuCommandes;

    public enum statutCommande {
        ENATTENTE("en attente"), ENCOURS("en cours"), LIVREE("livrée");

        public final String label;

        private statutCommande(String label){
            this.label = label;
        }
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "statut_commande", columnDefinition ="ENUM('en attente', 'en cours', 'livrée')")
    private statutCommande statutCommande;
    public Commande() {
    }

    public Commande(int commande_id, Client client, Livreur livreur, Magasin magasin, Date dateCommande, List<ContenuCommande> contenuCommandes, statutCommande statutCommande) {
        this.commande_id = commande_id;
        this.client = client;
        this.livreur = livreur;
        this.magasin = magasin;
        this.dateCommande = dateCommande;
        this.contenuCommandes = contenuCommandes;
        this.statutCommande = statutCommande;
    }

    public int getCommande_id() {
        return commande_id;
    }

    public Client getClient() {
        return client;
    }

    public Livreur getLivreur() {
        return livreur;
    }

    public Magasin getMagasin() {
        return magasin;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public List<ContenuCommande> getContenuCommandes() {
        return contenuCommandes;
    }

    public void setCommande_id(int commande_id) {
        this.commande_id = commande_id;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setLivreur(Livreur livreur) {
        this.livreur = livreur;
    }

    public void setMagasin(Magasin magasin) {
        this.magasin = magasin;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public void setContenuCommandes(List<ContenuCommande> contenuCommandes) {
        this.contenuCommandes = contenuCommandes;
    }

    public Commande.statutCommande getStatutCommande() {
        return statutCommande;
    }

    public void setStatutCommande(Commande.statutCommande statutCommande) {
        this.statutCommande = statutCommande;
    }
}