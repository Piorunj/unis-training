package trainingapp.training.service;

import org.springframework.stereotype.Service;

@Service
public interface UtilisateurService {
	
	boolean isExist(String login, String password);
}
