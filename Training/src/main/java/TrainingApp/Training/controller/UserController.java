package trainingapp.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import trainingapp.training.entite.Offre;
import trainingapp.training.entite.Transaction;
import trainingapp.training.entite.Utilisateur;
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

}
