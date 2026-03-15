package com.example.demo.model;

import jakarta.persistence.*;



@Entity
@Table(name = "mouvements")
public class Mouvement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private int quanity;
    private String date;
@ManyToOne
@JoinColumn(name = "produit_id")
    private Produit produit;

    public Mouvement() {}

    public Mouvement(Long id, String type, int quanity, String date, Produit produit) {
        this.id = id;
        this.type = type;
        this.quanity = quanity;
        this.date = date;
        this.produit = produit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}
