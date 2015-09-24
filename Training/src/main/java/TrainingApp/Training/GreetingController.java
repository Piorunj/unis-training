package TrainingApp.Training;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import TrainingApp.Training.service.UtilisateurService;

@Controller
@RequestMapping(value="/index")
public class GreetingController {
	
	private final Logger logger = LoggerFactory.getLogger(GreetingController.class);
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	private ModelAndView mav;
	
	   @RequestMapping(method = RequestMethod.GET)
	   public ModelAndView afficherForm() {
		   mav = new ModelAndView("index");
		   mav.addObject("monForm", new MonFormulaire());
		   return mav;
	   }
	   
	   @RequestMapping(method = RequestMethod.POST)
	   public String submitForm(@ModelAttribute("monForm") MonFormulaire monFormulaire) {
		   if(utilisateurService.isExist(monFormulaire.getLogin(), monFormulaire.getPassword())){ 
			   
			   return "user";
		   }
		   return "errorLogin";
	   }
}
