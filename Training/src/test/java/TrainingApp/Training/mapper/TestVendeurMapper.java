package trainingapp.training.mapper;

import org.fest.assertions.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import trainingapp.training.AbstractTrainingTest;
import trainingapp.training.entite.Vendeur;

public class TestVendeurMapper extends AbstractTrainingTest {

	@Autowired
	private VendeurMapper vendeurMapper;

	@Test
	public void testGetVendeurByIdSuccess() throws Exception {
		Vendeur vendeurRef = createVendeur();

		Vendeur vendeur = vendeurMapper.getVendeurById(vendeurRef.getId());
		Assertions.assertThat(vendeur).isNotNull();
		Assertions.assertThat(vendeur.getId()).isNotNull().isPositive().isEqualTo(vendeurRef.getId());
		Assertions.assertThat(vendeur.getNomEntreprise()).isNotNull().isEqualTo(vendeurRef.getNomEntreprise());
		Assertions.assertThat(vendeur.getUsrId()).isNotNull().isPositive().isEqualTo(vendeurRef.getUsrId());
	}

	@Test
	public void testGetVendeurByIdFail() throws Exception {
		Assertions.assertThat(vendeurMapper.getVendeurById(null)).isNull();
	}
}
