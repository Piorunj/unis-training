package trainingapp.training;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.sql.DataSource;

import org.apache.ibatis.jdbc.ScriptRunner;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import trainingapp.training.entite.Offre;
import trainingapp.training.entite.Produit;
import trainingapp.training.entite.Transaction;
import trainingapp.training.entite.Utilisateur;
import trainingapp.training.entite.Vendeur;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppConfig.class)
@WebAppConfiguration
@Transactional
@ActiveProfiles("test")
public abstract class AbstractTrainingTest {
	@Autowired
	private DataSource dataSource;
	
	private static Boolean hasBeenReset = Boolean.FALSE;

	@Before
	public void setUp() {
		if (!hasBeenReset) {
			Resource r = new ClassPathResource("test_script.sql");
			ScriptRunner runner = null;
			try {
				File reset = r.getFile();
				runner = new ScriptRunner(dataSource.getConnection());
				runner.runScript(new FileReader(reset));
			} catch (IOException | SQLException e) {
				throw new RuntimeException(e);
			} finally {
				runner.closeConnection();
				hasBeenReset = Boolean.TRUE;
			}
		}
	}
	
	protected Produit createProduit(){
		Produit produit = new Produit();
		produit.setId(1);
		produit.setNom("beta product");
		return produit;
	}
	
	protected Vendeur createVendeur(){
		Vendeur vendeur = new Vendeur();
		vendeur.setId(1);
		vendeur.setNomEntreprise("monEntreprise");
		vendeur.setUsrId(1);
		return vendeur;
	}
	
	protected Utilisateur createUser(){
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setId(1);
		utilisateur.setLogin("user1");
		utilisateur.setPassword("pass");
		utilisateur.setTelephone("0000000000");
		return utilisateur;
	}
	
	protected Offre createOffre(){
		Vendeur vendeur = createVendeur();
		Produit produit = createProduit();
		
		Offre offre = new Offre();
		offre.setId(1);
		offre.setPrixUnite(1);
		offre.setQuantite(1);
		offre.setUnite("kg");
		offre.setDateCreation(LocalDate.of(1993, 03, 26));
		offre.setVendeur(vendeur);
		offre.setProduit(produit);
		return offre;
	}
	
	protected Transaction createTransaction(){
		Transaction transaction = new Transaction();
		Offre offre = createOffre();
		
		Integer id = 1;
		Integer acheteurId = 1;
		LocalDate date = LocalDate.of(1993, 04, 26);
		
		transaction.setId(id);
		transaction.setAcheteurId(acheteurId);
		transaction.setDate(date);
		transaction.setOffre(offre);
		
		return transaction;
	}

}
