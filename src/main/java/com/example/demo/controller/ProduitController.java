package com.example.demo.controller;

import com.example.demo.model.Produit;
import com.example.demo.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProduitController {

    @Autowired
    private ProduitRepository produitRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/produits")
    public String listerProduits(Model model) {
        model.addAttribute("Produits", produitRepository.findAll());
        return "produits";
    }

    @GetMapping("/produits/ajouter")
    public String afficherFormulaire(Model model){
      model.addAttribute("Produit" , new Produit());
      return "ajouterProduit";
    }

    @PostMapping("/produits/ajouter")
    public String ajouterProduit(Produit produit){
        produitRepository.save(produit);
        return "redirect:/produits";
    }

}
