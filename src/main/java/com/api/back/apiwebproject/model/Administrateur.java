package com.api.back.apiwebproject.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "administrateurs")
public class Administrateur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false,updatable = false)
    private int administrateur_id;

    private String mot_de_passe;
    private String nomAdmin;

    private String mail_admin;

    private String role;

    public Administrateur(int administrateur_id, String mot_de_passe, String nomAdmin, String mail_admin, String role) {
        this.administrateur_id = administrateur_id;
        this.mot_de_passe = mot_de_passe;
        this.nomAdmin = nomAdmin;
        this.mail_admin = mail_admin;
        this.role = role;
    }

    public Administrateur() {
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String motdepasse) {
        this.mot_de_passe = motdepasse;
    }

    public int getAdministrateur_id() {
        return administrateur_id;
    }

    public void setAdministrateur_id(int administrateur_id) {
        this.administrateur_id = administrateur_id;
    }

    public String getNomAdmin() {
        return nomAdmin;
    }

    public void setNomAdmin(String nomAdmin) {
        this.nomAdmin = nomAdmin;
    }

    public String getMail_admin() {
        return mail_admin;
    }

    public void setMail_admin(String mailAdmin) {
        this.mail_admin = mailAdmin;
    }
}
