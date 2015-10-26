package trainingapp.training.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import trainingapp.training.entite.Offre;
import trainingapp.training.mapper.OffreMapper;
import trainingapp.training.service.OffreService;

@Service
public class OffreServiceImpl implements OffreService {

	@Autowired
	private OffreMapper offreMapper;
	
	@Override
	public List<Offre> getOffreParCritere(String produit, Integer quantiteMin, Integer quantiteMax, Integer prixMin,
			Integer prixMax) {
		return offreMapper.getOffreParCritere(produit, quantiteMin, quantiteMax, prixMin, prixMax);
	}

	@Override
	public List<Offre> getOffreByVendeurId(Integer vendeurId) {
		return offreMapper.getOffreByVendeurId(vendeurId);
	}

	@Override
	public void deleteOffreByOffreId(Integer offreId) {
		offreMapper.deleteOffreByOffreId(offreId);
	}

	@Override
	public void ajouterOffre(Integer produitId, Integer vendeurId, Integer quantite, String unite, Integer prixUnite, LocalDate dateCreation) {
		offreMapper.ajouterOffre(produitId, vendeurId, quantite, unite, prixUnite, dateCreation);
	}

}
