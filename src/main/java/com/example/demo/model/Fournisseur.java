package com.example.demo.model;


import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "fournisseurs")
public class Fournisseur {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String ville;
    private String telephone;
    @OneToMany(mappedBy = "fournisseur" , cascade = CascadeType.ALL)
    private List<Produit> produits;

    public Fournisseur(){}

    public Fournisseur(Long id, String name, String ville, String telephone , List<Produit> produits) {
        this.id = id;
        this.name = name;
        this.ville = ville;
        this.telephone = telephone;
        this.produits = produits;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<Produit> getProduits() {
        return produits;
    }
    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }
}
