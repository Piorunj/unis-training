package TrainingApp.Training.mapper;

import org.apache.ibatis.annotations.Param;

import TrainingApp.Training.entite.Utilisateur;

public interface UtilisateurMapper {
	
	public Utilisateur getUtilisateurById(int id);
	
	public boolean isExist(@Param("login") String login, @Param("password") String password);

}
