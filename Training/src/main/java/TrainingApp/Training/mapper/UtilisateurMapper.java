package trainingapp.training.mapper;

import org.apache.ibatis.annotations.Param;

import trainingapp.training.entite.Utilisateur;

public interface UtilisateurMapper {
	
	public Utilisateur getUtilisateurById(@Param("id") int id);
	
	public Integer isExist(@Param("login") String login, @Param("password") String password);

}
