package trainingapp.training.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import trainingapp.training.entite.Offre;

@Service
public interface OffreService {
	List<Offre> getOffreParCritere(String produit, Integer quantiteMin, Integer quantiteMax, Integer prixMin, Integer prixMax);
}
