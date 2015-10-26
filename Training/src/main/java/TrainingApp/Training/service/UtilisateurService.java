package trainingapp.training.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import trainingapp.training.entite.Utilisateur;

@Service
public interface UtilisateurService extends UserDetailsService{
	
	Utilisateur getUtilisateurById(Integer id);
	Integer isExist(String login, String password);
	UserDetails loadUserByUsername(String login);
	Utilisateur getUtilisateurAcheteurByLogin(String login);
	Utilisateur getUtilisateurVendeurByLogin(String login);
}
