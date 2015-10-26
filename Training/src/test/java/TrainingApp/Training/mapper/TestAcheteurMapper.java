package trainingapp.training.mapper;

import org.fest.assertions.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import trainingapp.training.AbstractTrainingTest;
import trainingapp.training.entite.Acheteur;

public class TestAcheteurMapper extends AbstractTrainingTest {
	@Autowired
	private AcheteurMapper acheteurMapper;

	@Test
	public void testGetAcheteurByUtilisateurLogin() throws Exception {
		Acheteur acheteurRef = createAcheteur();
		Acheteur acheteur = acheteurMapper.getAcheteurByUtilisateurLogin("user1");
		
		Assertions.assertThat(acheteur.getId()).isNotNull().isPositive().isEqualTo(acheteurRef.getId());
		
	}
}
