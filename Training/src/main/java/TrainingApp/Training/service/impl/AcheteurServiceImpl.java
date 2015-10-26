package trainingapp.training.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import trainingapp.training.entite.Acheteur;
import trainingapp.training.mapper.AcheteurMapper;
import trainingapp.training.service.AcheteurService;

@Service
public class AcheteurServiceImpl implements AcheteurService{

	@Autowired
	private AcheteurMapper acheteurMapper;
	
	@Override
	public Acheteur getAcheteurByUtilisateurLogin(String login) {
		return acheteurMapper.getAcheteurByUtilisateurLogin(login);
	}
}
