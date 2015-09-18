package TrainingApp.Training;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/index")
public class GreetingController {
	
	private final Logger logger = LoggerFactory.getLogger(GreetingController.class);
	
	   @RequestMapping(method = RequestMethod.GET)
	   public ModelAndView afficherForm() {
		   ModelAndView mav = new ModelAndView("index");
		   logger.debug("printHello is executed !!");
		   mav.addObject("monForm", new MonFormulaire());
		   return mav;
	   }
	   
	   @RequestMapping(method = RequestMethod.POST)
	   public String submitForm(@ModelAttribute("monForm") MonFormulaire monFormulaire) {
		   //TODO : traiter l'existence du login afind de savoir ou le rediriger
		   return "OK";
	   }
}
