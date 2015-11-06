package trainingapp.training.service;

import java.time.LocalDate;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import trainingapp.training.entite.Utilisateur;

@Service
public interface UtilisateurService extends UserDetailsService {

	Utilisateur getUtilisateurById(Integer id);

	Integer isExist(String login, String password);

	UserDetails loadUserByUsername(String login);

	Utilisateur getUtilisateurAcheteurByLogin(String login);

	Utilisateur getUtilisateurVendeurByLogin(String login);

	void createAcheteur(String login, String password, String telephone, String prenom, String nom, LocalDate date);

	void createVendeur(String login, String password, String telephone, String entreprise);
}
