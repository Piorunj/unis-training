package trainingapp.training.mapper;

import org.fest.assertions.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import trainingapp.training.AbstractTrainingTest;
import trainingapp.training.entite.Produit;

public class TestProduitMapper extends AbstractTrainingTest {
	@Autowired
	ProduitMapper produitMapper;

	@Test
	public void testGetProduitByIdSucess() throws Exception {
		Integer idProduit = 1;
		String nomProduit = "beta product";

		Produit produit = produitMapper.getProduitById(idProduit);
		Assertions.assertThat(produit.getNom()).isEqualTo(nomProduit);
	}

	@Test
	public void testGetProduitByIdFail() throws Exception {
		Assertions.assertThat(produitMapper.getProduitById(null));
	}
}
