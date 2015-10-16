package trainingapp.training.mapper;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.fest.assertions.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import trainingapp.training.AbstractTrainingTest;
import trainingapp.training.entite.Offre;
import trainingapp.training.entite.Produit;
import trainingapp.training.entite.Vendeur;

public class TestOffreMapper extends AbstractTrainingTest{
	@Autowired
	private OffreMapper offreMapper;

	@Test
	public void testGetOffreByIdSuccess() throws Exception {
		Offre offreRef = createOffre();
		Offre offre = offreMapper.getOffreById(1);
		
		Assertions.assertThat(offre.getId()).isNotNull().isPositive().isEqualTo(offreRef.getId());
		Assertions.assertThat(offre.getPrixUnite()).isNotNull().isPositive().isEqualTo(offreRef.getPrixUnite());
		Assertions.assertThat(offre.getQuantite()).isNotNull().isPositive().isEqualTo(offreRef.getQuantite());
		Assertions.assertThat(offre.getUnite()).isEqualTo(offreRef.getUnite());
		Assertions.assertThat(offre.getDateCreation().toString()).isEqualTo(offreRef.getDateCreation().toString());

		Assertions.assertThat(offre.getProduit()).isNotNull();
		Assertions.assertThat(offre.getProduit().getId()).isNotNull().isPositive().isEqualTo(offreRef.getProduit().getId());
		Assertions.assertThat(offre.getProduit().getNom()).isEqualTo(offreRef.getProduit().getNom());
		
		Assertions.assertThat(offre.getVendeur()).isNotNull();
		Assertions.assertThat(offre.getVendeur().getId()).isNotNull().isPositive().isEqualTo(offreRef.getVendeur().getId());
		Assertions.assertThat(offre.getVendeur().getNomEntreprise()).isEqualTo(offreRef.getVendeur().getNomEntreprise());
		Assertions.assertThat(offre.getVendeur().getUsrId()).isNotNull().isPositive().isEqualTo(offreRef.getVendeur().getUsrId());
	}
	
	@Test
	public void testGetOffreByIdFail() throws Exception {
		Assertions.assertThat(offreMapper.getOffreById(null)).isNull();
		Assertions.assertThat(offreMapper.getOffreById(0)).isNull();
	}
	
	@Test
	public void testGetOffreParNomProduitSuccess() throws Exception {
		Offre offre1 = createOffre();
		
		List<Offre> listRef = new ArrayList<Offre>();
		listRef.add(offre1);
		
		List<Offre> list = offreMapper.getOffreParCritere("beta", null, null, null, null);
		
		Assertions.assertThat(list).isNotNull().isNotEmpty().hasSize(listRef.size());
	}
	
	@Test
	public void testGetOffreSansCritereSuccess() throws Exception {
		Offre offre1 = createOffre();
		

		List<Offre> listRef = new ArrayList<Offre>();
		listRef.add(offre1);

		
		List<Offre> list = offreMapper.getOffreParCritere(null, null, null, null, null);
		
		Assertions.assertThat(list).isNotNull().isNotEmpty().hasSize(listRef.size());
	}
	
	@Test
	public void testGetOffreCritereQuantiteSuccess() throws Exception {
		Offre offre1 = createOffre();
		offre1.setId(2);
		
		List<Offre> listRef = new ArrayList<Offre>();
		listRef.add(offre1);
		
		List<Offre> list = offreMapper.getOffreParCritere(null, 1, 5, null, null);
		
		Assertions.assertThat(list).isNotNull().isNotEmpty().hasSize(listRef.size());
		
		Assertions.assertThat(list.get(0).getId()).isNotNull().isPositive().isEqualTo(listRef.get(0).getId());
	}
	
	@Test
	public void testGetOffreCriterePrixSuccess() throws Exception {
		Offre offre1 = createOffre();

		
		List<Offre> listRef = new ArrayList<Offre>();
		listRef.add(offre1);

		
		List<Offre> list = offreMapper.getOffreParCritere(null, null, null, 1, 5);
		
		Assertions.assertThat(list).isNotNull().isNotEmpty().hasSize(listRef.size());

	}
	
	@Test
	public void testGetOffreCritereSansResultatSuccess() throws Exception {
		
		List<Offre> list = offreMapper.getOffreParCritere("test", 2, 5, 1, 3);
		
		Assertions.assertThat(list).isNotNull().isEmpty();
	}
	
}
