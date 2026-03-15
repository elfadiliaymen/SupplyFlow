package com.example.demo.service;

import com.example.demo.model.Mouvement;
import com.example.demo.model.Produit;
import com.example.demo.repository.MouvementRepository;
import com.example.demo.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MouvementService {

    @Autowired
    private MouvementRepository mouvementRepository;

    @Autowired
    private ProduitRepository produitRepository;

    public void enregistrerMouvement(Mouvement mouvement){
        Produit produit = produitRepository.findById(mouvement.getProduit().getId())
                .orElseThrow(() -> new RuntimeException("Produit introuvable"));

        if("Entree".equalsIgnoreCase(mouvement.getType())){
            produit.setStock(produit.getStock() + mouvement.getQuanity());
        } else if ("Sortie".equalsIgnoreCase(mouvement.getType())) {
            if(produit.getStock() < mouvement.getQuanity()){
                throw new RuntimeException("Stock insuffisant !");
            }
            produit.setStock(produit.getStock() - mouvement.getQuanity());
        }

        produitRepository.save(produit);
        mouvementRepository.save(mouvement);
    }
}
