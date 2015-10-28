package trainingapp.training.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import scala.annotation.meta.getter;
import trainingapp.training.FormulaireCreationOffre;
import trainingapp.training.FormulaireRechercheOffre;
import trainingapp.training.entite.Offre;
import trainingapp.training.entite.Produit;
import trainingapp.training.entite.Utilisateur;
import trainingapp.training.service.OffreService;
import trainingapp.training.service.ProduitService;
import trainingapp.training.service.TransactionService;
import trainingapp.training.service.UtilisateurService;
import trainingapp.training.service.VendeurService;

@Controller
@RequestMapping(value="/offre")
public class OffreController {

	@Autowired
	private OffreService offreService;

	@Autowired
	private ProduitService produitService;

	@Autowired
	private TransactionService transactionService;

	@Autowired
	private UtilisateurService utilisateurService;

	@Autowired
	private VendeurService vendeurService;

	private ModelAndView mav;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView resultatRecherche(@ModelAttribute("formulaireRechercheOffre") final FormulaireRechercheOffre formulaire){
		mav = new ModelAndView("offre");
		if(formulaire != null && !formulaire.isEmpty()){
			List<Offre> offres = offreService.getOffreParCritere(formulaire.getProduit(), formulaire.getQtMin(), formulaire.getQtMax(), formulaire.getPrixMin(),formulaire.getPrixMax());
			mav.addObject("offres", offres);
		}
		mav.addObject("formulaireRechercheOffre", formulaire);
		return mav;
	}


	@RequestMapping(method = RequestMethod.GET, value="{idOffre}")
	public ModelAndView ajoutTransaction(@ModelAttribute("formulaireRechercheOffre") FormulaireRechercheOffre formulaire, @PathVariable Integer idOffre){
		mav = new ModelAndView("offre");
		if(formulaire != null && !formulaire.isEmpty()){
			List<Offre> offres = offreService.getOffreParCritere(formulaire.getProduit(), formulaire.getQtMin(), formulaire.getQtMax(), formulaire.getPrixMin(),formulaire.getPrixMax());
			mav.addObject("offres", offres);
		}
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		transactionService.addTransaction(idOffre, utilisateurService.getUtilisateurAcheteurByLogin(auth.getName()).getId());
		mav.addObject("formulaireRechercheOffre", new FormulaireRechercheOffre());
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST, value="/new")
	public ModelAndView creationOffre(@Validated @ModelAttribute("formulaireCreationOffre") final FormulaireCreationOffre formulaire, final BindingResult br){
		mav = new ModelAndView("newOffre");
		if(formulaire !=null && formulaire.correctlySet() && !br.hasErrors()){

			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			Utilisateur utilisateur = utilisateurService.getUtilisateurVendeurByLogin(auth.getName());

			Produit produit = produitService.getProduitByName(formulaire.getProduit());
			Integer produitId;
			if(produit == null){
				produitService.ajouterProduit(formulaire.getProduit());
				produit = produitService.getProduitByName(formulaire.getProduit());
			}
			produitId = produit.getId();
			LocalDate dateOffre = LocalDate.now();	
			Integer vendeurId = vendeurService.getVendeurByUtilisateurLogin(utilisateur.getLogin()).getId();
			offreService.ajouterOffre(produitId, vendeurId, formulaire.getQuantite(), formulaire.getUnite(), formulaire.getPrixUnite(), dateOffre);
			Offre recap = new Offre();
			recap.setProduit(produit);
			recap.setPrixUnite(formulaire.getPrixUnite());
			recap.setQuantite(formulaire.getQuantite());
			recap.setUnite(formulaire.getUnite());
			recap.setDateCreation(dateOffre);

			mav.addObject("recap", recap);
		}
		mav.addObject("fomulaireCreationOffre", new FormulaireCreationOffre());
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/new")
	public ModelAndView firstLoadNewOffre(@ModelAttribute("formulaireCreationOffre") final FormulaireCreationOffre formulaire){
		mav = new ModelAndView("newOffre");
		mav.addObject("fomulaireCreationOffre", new FormulaireCreationOffre());
		return mav;
	}
}
