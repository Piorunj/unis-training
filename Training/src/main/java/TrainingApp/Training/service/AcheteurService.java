package trainingapp.training.service;

import org.springframework.stereotype.Service;

import trainingapp.training.entite.Acheteur;

@Service
public interface AcheteurService {
	Acheteur getAcheteurByUtilisateurLogin(String login);
}
