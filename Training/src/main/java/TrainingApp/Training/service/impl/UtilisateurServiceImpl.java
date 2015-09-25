package trainingapp.training.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import trainingapp.training.mapper.UtilisateurMapper;
import trainingapp.training.service.UtilisateurService;

@Service
public class UtilisateurServiceImpl implements UtilisateurService{
	
	@Autowired
	private UtilisateurMapper utilisateurMapper;

	@Override
	public Integer isExist(String login, String password) {
		return utilisateurMapper.isExist(login, password);
	}

}
