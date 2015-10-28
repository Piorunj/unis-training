package trainingapp.training.service;

import org.springframework.stereotype.Service;

import trainingapp.training.entite.Produit;

@Service
public interface ProduitService {
	Produit getProduitByName(String nom);
	Produit getProduitById (Integer id);
	void ajouterProduit (String nomProduit);
}
