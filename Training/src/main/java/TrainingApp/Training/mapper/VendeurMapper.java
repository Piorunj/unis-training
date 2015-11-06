package trainingapp.training.mapper;

import org.apache.ibatis.annotations.Param;

import trainingapp.training.entite.Vendeur;

public interface VendeurMapper {

	public Vendeur getVendeurById(@Param("id") Integer id);

	public Vendeur getVendeurByUtilisateurLogin(@Param("login") String login);

	public void createVendeur(@Param("usrId") Integer id, @Param("entreprise") String entreprise);

}
