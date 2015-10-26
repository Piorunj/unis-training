package trainingapp.training.mapper;

import org.apache.ibatis.annotations.Param;

import trainingapp.training.entite.Acheteur;

public interface AcheteurMapper {
	
	public Acheteur getAcheteurByUtilisateurLogin(@Param("login") String login);
	

}
