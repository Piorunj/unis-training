package trainingapp.training.service.impl;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import trainingapp.training.entite.Acheteur;
import trainingapp.training.entite.Utilisateur;
import trainingapp.training.mapper.AcheteurMapper;
import trainingapp.training.mapper.UtilisateurMapper;
import trainingapp.training.mapper.VendeurMapper;
import trainingapp.training.service.UtilisateurService;

@Service
public class UtilisateurServiceImpl implements UtilisateurService{
	
	@Autowired
	private UtilisateurMapper utilisateurMapper;
	
	@Autowired
	private AcheteurMapper acheteurMapper;
	
	@Autowired
	private VendeurMapper vendeurMapper;

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

	@Override
	public Utilisateur getUtilisateurVendeurByLogin(String login) {
		return utilisateurMapper.getUtilisateurVendeurByLogin(login);
	}

	@Override
	public void createAcheteur(String login, String password, String telephone, String prenom, String nom,
			LocalDate date) {
		Utilisateur user = new Utilisateur();
		user.setLogin(login);
		user.setPassword(password);
		user.setTelephone(telephone);
		utilisateurMapper.createUtilisateur(user);
		
		acheteurMapper.createAcheteur(user.getId(), prenom, nom, date);
		
	}

	@Override
	public void createVendeur(String login, String password, String telephone, String entreprise) {
		Utilisateur user = new Utilisateur();
		user.setLogin(login);
		user.setPassword(password);
		user.setTelephone(telephone);
		
		utilisateurMapper.createUtilisateur(user);
		vendeurMapper.createVendeur(user.getId(), entreprise);
		
	}


}
