package trainingapp.training.service;

import org.springframework.stereotype.Service;

import trainingapp.training.entite.Utilisateur;

@Service
public interface UtilisateurService {
	
	Utilisateur getUtilisateurById(Integer id);
	Integer isExist(String login, String password);
}
