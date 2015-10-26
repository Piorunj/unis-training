package trainingapp.training.service;

import org.springframework.stereotype.Service;

import trainingapp.training.entite.Vendeur;

@Service
public interface VendeurService {
	Vendeur getVendeurByUtilisateurLogin(String login);
}
