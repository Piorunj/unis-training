package trainingapp.training.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import trainingapp.training.entite.Produit;
import trainingapp.training.mapper.ProduitMapper;
import trainingapp.training.service.ProduitService;

@Service
public class ProduitServiceImpl implements ProduitService {

	@Autowired
	private ProduitMapper produitMapper;

	@Override
	public Produit getProduitByName(String nom) {
		return produitMapper.getProduitByName(nom);
	}

	@Override
	public Produit getProduitById(Integer id) {
		return produitMapper.getProduitById(id);
	}

	@Override
	public void ajouterProduit(String nomProduit) {
		produitMapper.ajouterProduit(nomProduit);
	}

}
