package trainingapp.training.mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import trainingapp.training.entite.Offre;

public interface OffreMapper {

	public Offre getOffreById(Integer id);

	public List<Offre> getOffreParCritere(@Param("produit") String produit,@Param("quantiteMin") Integer quantiteMin,@Param("quantiteMax") Integer quantiteMax,@Param("prixMin") Integer prixMin,
			@Param("prixMax") Integer prixMax);
	
	public List<Offre> getOffreByVendeurId(@Param("id") Integer vendeurId);
	
	public void deleteOffreByOffreId(@Param("id") Integer offreId);

	public void ajouterOffre(@Param("produitId") Integer produitId, @Param("vendeurId") Integer vendeurId, @Param("quantite") Integer quantite, @Param("unite") String unite, @Param("prixUnite") Integer prixUnite, @Param("dateCreation") LocalDate dateCreation);

}
