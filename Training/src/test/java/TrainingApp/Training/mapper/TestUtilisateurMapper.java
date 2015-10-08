package trainingapp.training.mapper;

import org.fest.assertions.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import trainingapp.training.AbstractTrainingTest;
import trainingapp.training.entite.Utilisateur;

public class TestUtilisateurMapper extends AbstractTrainingTest{

	@Autowired
	private UtilisateurMapper utilisateurMapper;

	@Test
	public void testGetUtilisateurByIdSuccess() throws Exception{
		Integer id = 1;
		String login = "user1";
		String password = "pass";
		String telephone = "0600000000";

		Utilisateur utilisateur = utilisateurMapper.getUtilisateurById(id);

		Assertions.assertThat(utilisateur.getId()).isNotNull().isPositive().isEqualTo(id);
		Assertions.assertThat(utilisateur.getLogin()).isNotNull().isEqualTo(login);
		Assertions.assertThat(utilisateur.getPassword()).isNotNull().isEqualTo(password);
		Assertions.assertThat(utilisateur.getTelephone()).isNotNull().isEqualTo(telephone);
	}

	@Test
	public void testGetUtilisateurByIdFail() throws Exception{
		Assertions.assertThat(utilisateurMapper.getUtilisateurById(null)).isNull();
		Assertions.assertThat(utilisateurMapper.getUtilisateurById(Integer.MAX_VALUE)).isNull();
	}

	@Test
	public void testIsExistSUcess() throws Exception {
		Integer id = 1;
		String login = "user1";
		String password = "pass";

		Assertions.assertThat(utilisateurMapper.isExist(login, password)).isNotNull().isPositive().isEqualTo(id);
	}

	@Test
	public void testIsExistFail() throws Exception {
		Assertions.assertThat(utilisateurMapper.isExist(null, null)).isNull();
		Assertions.assertThat(utilisateurMapper.isExist("", "")).isNull();;
	}

}
