package com.example.demo.controller;

import com.example.demo.model.Produit;
import com.example.demo.repository.FournisseurRepository;
import com.example.demo.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProduitController {

    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private FournisseurRepository fournisseurRepository;

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
      model.addAttribute("Fournisseurs" , fournisseurRepository.findAll());
      return "ajouterProduit";
    }

    @PostMapping("/produits/ajouter")
    public String ajouterProduit(Produit produit){
        produitRepository.save(produit);
        return "redirect:/produits";
    }

    @GetMapping("/produits/delete/{id}")
    public String supprimerProduit(@PathVariable("id") Long id)
    {
        produitRepository.deleteById(id);
        return "redirect:/produits";
    }

    @GetMapping("/produits/modifier/{id}")
    public String afficherFormModifier(@PathVariable("id") Long id , Model model)
    {
      model.addAttribute("Produit" , produitRepository.findById(id).get());
      model.addAttribute("Fournisseurs" , fournisseurRepository.findAll());
      return "modifierProduit";
    }

    @GetMapping("/produits/update")
    public String updateProduit(Produit produit)
    {
        produitRepository.save(produit);
        return "redirect:/produits";
    }

    @GetMapping("/produits/recherche")
    public String getProduitParNom(@RequestParam("designation") String designation , Model model){
        List<Produit> resultas = produitRepository.findByDesignationContainingIgnoreCase(designation);
        model.addAttribute("Produits", resultas);
        model.addAttribute("recherche", designation);
        return "produits";
    }

    @GetMapping("/produits/fournisseur/{id}")
    public String getProduitDeFournisseur(@PathVariable("id") Long id , Model model){
        List<Produit> produitsDefournisseur = produitRepository.findByFournisseurId(id);
        model.addAttribute("Produits" , produitsDefournisseur);
        return "produits";
    }

}
