package trainingapp.training.service;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import trainingapp.training.entite.Offre;

@Service
public interface OffreService {
	List<Offre> getOffreParCritere(String produit, Integer quantiteMin, Integer quantiteMax, Integer prixMin, Integer prixMax);
	
	List<Offre> getOffreByVendeurId(Integer vendeurId);
	
	void deleteOffreByOffreId(Integer offreId);

	void ajouterOffre(Integer produitId, Integer vendeurId, Integer quantite, String unite, Integer prixUnite, LocalDate dateCreation);
	
}
