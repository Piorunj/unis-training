package trainingapp.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import trainingapp.training.entite.Transaction;
import trainingapp.training.entite.Utilisateur;
import trainingapp.training.service.TransactionService;
import trainingapp.training.service.UtilisateurService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	
	@Autowired
	private UtilisateurService utilisateurService;

	@Autowired
	private TransactionService transactionService;

	private ModelAndView mav;

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submitForm(@RequestParam("user") String user, @RequestParam("password") String password) {
		Integer utilisateurId = utilisateurService.isExist(user, password);
		Utilisateur u = utilisateurService.getUtilisateurById(utilisateurId);
		List<Transaction> transactionList;
		mav = new ModelAndView();
		if(utilisateurId != null){
			transactionList = transactionService.getAllTransactionByAcheteurId(utilisateurId); 
			mav.addObject("transactionList", transactionList);
			mav.setViewName("user");
		}else{
			mav.setViewName("login");
			mav.addObject("error", "couple login/mot de passe incorrect");
		}
		return mav;
	}

}
