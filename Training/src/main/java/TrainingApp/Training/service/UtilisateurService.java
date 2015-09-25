package trainingapp.training.service;

import org.springframework.stereotype.Service;

@Service
public interface UtilisateurService {
	
	Integer isExist(String login, String password);
}
