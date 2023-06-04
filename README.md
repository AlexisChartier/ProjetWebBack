# ProjetWeb

Vous trouverez ici une description détaillée du projet "DeliveryGo"

## Description du projet

DeliveryGo est une application web dont le principe est de mettre à disposition une plateforme où vendeurs particuliers ou professionnels puissent proposer leurs produits que des clients pourront commander, la livraison étant prise en charge directement sur l'application par les livreurs qui pourront prendre les commandes et mettre à jour l'état de la commande.

## Choix techniques

### Front-End 

JavaScript/TypeScript via Framework angular
DB (en local pour l'instant) mySql

### Back-End

API -> Java Framework springboot
jdk17
Spring 3.0.5

## Architecture du projet


## Structure de la base de données

Tables : 
- admin(<ins>idAdmin</ins>,nom,prenom,dateNaissance,Adresse,numTel,mail,mdp)
- client(<ins>idClient</ins>nom,prenom,dateNaissance,Adresse,numTel,mail,mdp)
- livreur(<ins>idLivreur</ins>,nom,prenom,dateNaissance,Adresse,numTel,mail,nbLivraisons,note,mdp)
- vendeur(<ins>idVendeur</ins>,nom,prenom,dateNaissance,Adresse,numTel,mail,#idMagasin,mdp)
- magasin(<ins>idMagasin</ins>,nomM,horairesM,AdresseM,numTel,mail)
- produit(<ins>idProduit</ins>,categorie,nom,description,prix,qteStock,idMagasin#)
- commande(<ins>idCommande</ins>,dateCommande,idClient#,idMagasin#,total)
- contenuCommande(<ins>idCommande</ins>,<ins>idProduit</ins>,qte)
- livraison(<ins>idLivraison</ins>,distance,revenu,idLivreur#)


## Fonctionnalités du site
