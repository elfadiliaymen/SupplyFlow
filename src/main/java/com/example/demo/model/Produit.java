package com.example.demo.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "produits")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String designation;
    private double prix;
    private int stock;
    @ManyToOne
    @JoinColumn(name = "fournisseur_id")
    private Fournisseur fournisseur;

    @OneToMany(mappedBy = "produit" , cascade = CascadeType.ALL)
    private List<Mouvement> mouvment;

    public Produit(){}


    public Produit(Long id, String designation, double prix, int stock , Fournisseur fournisseur) {
        this.id = id;
        this.designation = designation;
        this.prix = prix;
        this.stock = stock;
        this.fournisseur = fournisseur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }
    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }


}
