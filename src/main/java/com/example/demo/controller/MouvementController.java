package com.example.demo.controller;

import com.example.demo.model.Mouvement;
import com.example.demo.repository.MouvementRepository;
import com.example.demo.service.MouvementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.repository.ProduitRepository;

@Controller
public class MouvementController {

    @Autowired
    MouvementRepository mouvementRepository;

    @Autowired
    ProduitRepository produitRepository;

    @Autowired
    MouvementService mouvementService;

    @GetMapping("/mouvements")
    public String afficherMouvments(Model model){
        model.addAttribute("Mouvements" , mouvementRepository.findAll());
        return "mouvements";
    }

    @GetMapping("/mouvements/ajouter")
    public String afficherFormulaire(Model model){
        model.addAttribute("Mouvement" , new Mouvement());
        model.addAttribute("Produits" , produitRepository.findAll());
        return "ajouterMouvement";
    }

    @PostMapping("/mouvements/ajouter")
    public String ajouterMouvement(Mouvement mouvement){
       mouvementService.enregistrerMouvement(mouvement);
        return "redirect:/mouvements";
    }
}
