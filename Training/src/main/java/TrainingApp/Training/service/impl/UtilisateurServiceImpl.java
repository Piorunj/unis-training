package trainingapp.training.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import trainingapp.training.entite.Utilisateur;
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

	@Override
	public Utilisateur getUtilisateurById(Integer id) {
		return utilisateurMapper.getUtilisateurById(id);
	}


	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Utilisateur utilisateur = utilisateurMapper.getUtilisateurAcheteurByLogin(login);
		if(utilisateur == null){
			utilisateur = utilisateurMapper.getUtilisateurVendeurByLogin(login);
			if(utilisateur == null){
				throw new UsernameNotFoundException("Login inexistant");
			}else{
				final GrantedAuthority authority = new SimpleGrantedAuthority("VENDEUR");
				return new User(utilisateur.getLogin(), utilisateur.getPassword(), Arrays.asList(authority));
			}
		}
		final GrantedAuthority authority = new SimpleGrantedAuthority("ACHETEUR");
		return new User(utilisateur.getLogin(), utilisateur.getPassword(), Arrays.asList(authority));
	}

	@Override
	public Utilisateur getUtilisateurAcheteurByLogin(String login) {
		return utilisateurMapper.getUtilisateurAcheteurByLogin(login);
	}


}
