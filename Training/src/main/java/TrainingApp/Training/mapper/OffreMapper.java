package trainingapp.training.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import trainingapp.training.entite.Offre;

public interface OffreMapper {

	public Offre getOffreById(Integer id);

	public List<Offre> getOffreParCritere(@Param("produit") String produit,@Param("quantiteMin") Integer quantiteMin,@Param("quantiteMax") Integer quantiteMax,@Param("prixMin") Integer prixMin,
			@Param("prixMax") Integer prixMax);

}
