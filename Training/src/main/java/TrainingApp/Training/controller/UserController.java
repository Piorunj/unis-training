package trainingapp.training.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import trainingapp.training.FormulaireCreationAcheteur;
import trainingapp.training.FormulaireCreationVendeur;
import trainingapp.training.entite.Acheteur;
import trainingapp.training.entite.Offre;
import trainingapp.training.entite.Transaction;
import trainingapp.training.entite.Utilisateur;
import trainingapp.training.entite.Vendeur;
import trainingapp.training.service.AcheteurService;
import trainingapp.training.service.OffreService;
import trainingapp.training.service.TransactionService;
import trainingapp.training.service.UtilisateurService;
import trainingapp.training.service.VendeurService;

@Controller
@RequestMapping(value="/user")
public class UserController {


	@Autowired
	private UtilisateurService utilisateurService;

	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private AcheteurService acheteurService;
	
	@Autowired
	private VendeurService vendeurService;
	
	@Autowired
	private OffreService offreService;

	private ModelAndView mav;

	@PreAuthorize("hasRole('ACHETEUR')")
	@RequestMapping(value="/acheteur", method = RequestMethod.GET)
	public ModelAndView submitForm() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Utilisateur utilisateur = utilisateurService.getUtilisateurAcheteurByLogin(auth.getName());

		Integer acheteurId = acheteurService.getAcheteurByUtilisateurLogin(utilisateur.getLogin()).getId();

		
		mav = new ModelAndView();

		List<Transaction> transactionList;
		transactionList = transactionService.getAllTransactionByAcheteurId(acheteurId); 
		mav.addObject("transactionList", transactionList);
		mav.addObject("usrName", utilisateur.getLogin());
		mav.setViewName("acheteur");

		return mav;
	}
	
	@PreAuthorize("hasRole('ACHETEUR')")
	@RequestMapping(value="/acheteur/desc", method = RequestMethod.GET)
	public ModelAndView descriptionAcheteur() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Utilisateur utilisateur = utilisateurService.getUtilisateurAcheteurByLogin(auth.getName());	
		Acheteur acheteur = acheteurService.getAcheteurByUtilisateurLogin(utilisateur.getLogin());
		mav = new ModelAndView();
		mav.addObject("user", utilisateur);
		mav.addObject("acheteur", acheteur);
		mav.setViewName("descAcheteur");

		return mav;
	}
	
	@PreAuthorize("hasRole('VENDEUR')")
	@RequestMapping(value="/vendeur/desc", method = RequestMethod.GET)
	public ModelAndView descriptionVendeur() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Utilisateur utilisateur = utilisateurService.getUtilisateurVendeurByLogin(auth.getName());	
		Vendeur vendeur = vendeurService.getVendeurByUtilisateurLogin(utilisateur.getLogin());
		mav = new ModelAndView();
		mav.addObject("user", utilisateur);
		mav.addObject("vendeur", vendeur);
		mav.setViewName("descVendeur");

		return mav;
	}
	
	@PreAuthorize("hasRole('VENDEUR')")
	@RequestMapping(value="/vendeur", method = RequestMethod.GET)
	public ModelAndView submitFormVendeur(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Utilisateur utilisateur = utilisateurService.getUtilisateurVendeurByLogin(auth.getName());
		
		Integer vendeurId = vendeurService.getVendeurByUtilisateurLogin(utilisateur.getLogin()).getId();
		mav = new ModelAndView();
		
		List<Transaction> transactionList;
		transactionList = transactionService.getAllTransactionByVendeurId(vendeurId); 
		mav.addObject("transactionList", transactionList);
		mav.addObject("usrName", utilisateur.getLogin());
		mav.setViewName("vendeur");
		
		List<Offre> offreList;
		offreList = offreService.getOffreByVendeurId(vendeurId);
		mav.addObject("offreList", offreList);
		return mav;
	}
	
	@PreAuthorize("hasRole('VENDEUR')")
	@RequestMapping(value="/vendeur/delete{offreId}", method = RequestMethod.GET)
	public ModelAndView suppressionOffreVendeur(@PathVariable Integer offreId){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Utilisateur utilisateur = utilisateurService.getUtilisateurVendeurByLogin(auth.getName());
		
		Integer vendeurId = vendeurService.getVendeurByUtilisateurLogin(utilisateur.getLogin()).getId();
		mav = new ModelAndView();
		
		offreService.deleteOffreByOffreId(offreId);
		
		List<Transaction> transactionList;
		transactionList = transactionService.getAllTransactionByVendeurId(vendeurId); 
		mav.addObject("transactionList", transactionList);
		mav.addObject("usrName", utilisateur.getLogin());
		mav.setViewName("vendeur");
		
		List<Offre> offreList;
		offreList = offreService.getOffreByVendeurId(vendeurId);
		mav.addObject("offreList", offreList);
		return mav;
	}
	
	// premier chargement de la page de creation de compte
	@RequestMapping(value="create", method=RequestMethod.GET)
	public ModelAndView firstLoadNewUser(){
		mav = new ModelAndView("newUser");
		mav.addObject("formulaireCreationAcheteur", new FormulaireCreationAcheteur());
		mav.addObject("formulaireCreationVendeur", new FormulaireCreationVendeur());
		return mav;
	}
	
	@RequestMapping(value="/create/acheteur", method= RequestMethod.POST)
	public ModelAndView creationUtilisateurAcheteur(@ModelAttribute("formulaireCreationAcheteur") final FormulaireCreationAcheteur formulaireCreationAcheteur){
		mav = new ModelAndView();
		if (formulaireCreationAcheteur == null || !formulaireCreationAcheteur.isCorrectlySet()){
			mav.setViewName("error");
			return mav;
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate date = LocalDate.parse(formulaireCreationAcheteur.getDateNaissance(), formatter);
		utilisateurService.createAcheteur(formulaireCreationAcheteur.getLogin(), formulaireCreationAcheteur.getPassword(), formulaireCreationAcheteur.getTelephone(), formulaireCreationAcheteur.getPrenom(), formulaireCreationAcheteur.getNom(), date);		
		mav.setViewName("home");
		return mav;
	}

	
	@RequestMapping(value="/create/vendeur", method= RequestMethod.POST)
	public ModelAndView creationUtilisateurVendeur(@ModelAttribute("formulaireCreationVendeur") final FormulaireCreationVendeur formulaireCreationVendeur){
		mav = new ModelAndView();
		if (formulaireCreationVendeur == null || !formulaireCreationVendeur.isCorrectlySet()){
			mav.setViewName("error");
			return mav;
		}
		utilisateurService.createVendeur(formulaireCreationVendeur.getLogin(), formulaireCreationVendeur.getPassword(), formulaireCreationVendeur.getTelephone(), formulaireCreationVendeur.getEntreprise());		
		mav.setViewName("home");
		return mav;
	}

}
