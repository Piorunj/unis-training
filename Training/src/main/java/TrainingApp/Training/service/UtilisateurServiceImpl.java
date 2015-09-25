package trainingapp.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import trainingapp.training.mapper.UtilisateurMapper;

@Service
public class UtilisateurServiceImpl implements UtilisateurService{
	
	@Autowired
	private UtilisateurMapper utilisateurMapper;

	@Override
	public boolean isExist(String login, String password) {
		return utilisateurMapper.isExist(login, password);
	}

}
