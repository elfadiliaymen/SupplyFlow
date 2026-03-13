package com.example.demo.controller;


import com.example.demo.model.Fournisseur;
import com.example.demo.repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FournisseurController {

    @Autowired
    FournisseurRepository fournisseurRepository;


    @GetMapping("/fournisseurs")
    public String afficherFournisseurs(Model model){
      model.addAttribute("Fournisseurs" , fournisseurRepository.findAll());
      return "fournisseurs";
    }

    @GetMapping("/fournisseurs/ajouter")
    public String afficherFormulaire(Model model){
        model.addAttribute("Fournisseur" , new Fournisseur());
        return "ajouterFournisseur";
    }

    @PostMapping("/fournisseurs/ajouter")
    public String ajouterFournisseur(Fournisseur fournisseur){
        fournisseurRepository.save(fournisseur);
        return "redirect:/fournisseurs";
    }


}
