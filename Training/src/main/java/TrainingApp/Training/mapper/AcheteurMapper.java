package trainingapp.training.mapper;

import java.time.LocalDate;

import org.apache.ibatis.annotations.Param;

import trainingapp.training.entite.Acheteur;

public interface AcheteurMapper {
	
	public Acheteur getAcheteurByUtilisateurLogin(@Param("login") String login);

	public void createAcheteur(Integer usrId, String prenom, String nom, LocalDate date);
	

}
