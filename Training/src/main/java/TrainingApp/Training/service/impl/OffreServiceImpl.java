package trainingapp.training.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
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

}
