package trainingapp.training.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import trainingapp.training.entite.Vendeur;
import trainingapp.training.mapper.VendeurMapper;
import trainingapp.training.service.VendeurService;

@Service
public class VendeurServiceImpl implements VendeurService{
	
	@Autowired
	private VendeurMapper vendeurMapper;

	@Override
	public Vendeur getVendeurByUtilisateurLogin(String login) {
		return vendeurMapper.getVendeurByUtilisateurLogin(login);
	}
	
	
}
