package trainingapp.training.mapper;

import org.apache.ibatis.annotations.Param;

import trainingapp.training.entite.Utilisateur;

public interface UtilisateurMapper {
	
	public Utilisateur getUtilisateurById(@Param("id") Integer id);
	
	public Integer isExist(@Param("login") String login, @Param("password") String password);
	
	public Utilisateur getUtilisateurAcheteurByLogin(@Param("login") String login);

	public Utilisateur getUtilisateurVendeurByLogin(@Param("login")String login);
	
}
