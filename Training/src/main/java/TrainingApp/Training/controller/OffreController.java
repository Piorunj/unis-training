package trainingapp.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import scala.annotation.meta.getter;
import trainingapp.training.FormulaireRechercheOffre;
import trainingapp.training.entite.Offre;
import trainingapp.training.service.OffreService;
import trainingapp.training.service.TransactionService;
import trainingapp.training.service.UtilisateurService;

@Controller
@RequestMapping(value="/offre")
public class OffreController {

	@Autowired
	private OffreService offreService;
	
	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private UtilisateurService utilisateurService;

	private ModelAndView mav;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView resultatRecherche(@ModelAttribute("formulaireRechercheOffre") FormulaireRechercheOffre formulaire){
		mav = new ModelAndView("offre");
		if(formulaire != null && !formulaire.isEmpty()){
			List<Offre> offres = offreService.getOffreParCritere(formulaire.getProduit(), formulaire.getQtMin(), formulaire.getQtMax(), formulaire.getPrixMin(),formulaire.getPrixMax());
			mav.addObject("offres", offres);
		}
		mav.addObject("formulaireRechercheOffre", new FormulaireRechercheOffre());
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
	
}
