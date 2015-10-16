package trainingapp.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@Controller
@RequestMapping(value="/offre")
public class OffreController {

	@Autowired
	private OffreService offreService;
	
	@Autowired
	private TransactionService transactionService;

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
	
}
