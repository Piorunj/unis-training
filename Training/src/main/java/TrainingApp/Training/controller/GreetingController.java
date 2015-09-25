package trainingapp.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import trainingapp.training.MonFormulaire;
import trainingapp.training.entite.Transaction;
import trainingapp.training.service.TransactionService;
import trainingapp.training.service.UtilisateurService;

@Controller
@RequestMapping(value="/index")
public class GreetingController {
	
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	@Autowired
	private TransactionService transactionService;
	
	private ModelAndView mav;
	
	   @RequestMapping(method = RequestMethod.GET)
	   public ModelAndView afficherForm() {
		   mav = new ModelAndView("index");
		   mav.addObject("monForm", new MonFormulaire());
		   return mav;
	   }
	   
	   @RequestMapping(method = RequestMethod.POST)
	   public ModelAndView submitForm(@ModelAttribute("monForm") MonFormulaire monFormulaire) {
		   Integer utilisateurId = utilisateurService.isExist(monFormulaire.getLogin(), monFormulaire.getPassword());
		   List<Transaction> transactionList;
		   mav = new ModelAndView("user");
		   if(utilisateurId != null){
			   transactionList = transactionService.getAllTransactionByAcheteurId(utilisateurId); 
			   mav.addObject("transactionList", transactionList);
		   }
		   return mav;
	   }
	   
	   
}
