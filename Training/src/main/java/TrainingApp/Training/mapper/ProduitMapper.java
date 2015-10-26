package trainingapp.training.mapper;

import org.apache.ibatis.annotations.Param;

import trainingapp.training.entite.Produit;

public interface ProduitMapper {
	public Produit getProduitById(@Param("id") Integer id);

	public Produit getProduitByName(@Param("nom") String nom);

	public void ajouterProduit(@Param("nom") String nomProduit);

}
