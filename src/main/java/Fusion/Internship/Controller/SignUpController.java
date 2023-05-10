package Fusion.Internship.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Fusion.Internship.Service.LoggerService;


@Controller
@RequestMapping(value = { "/SignUp" })
public class SignUpController {
	
	@Autowired
	LoggerService logger;
	
	@GetMapping
	public ModelAndView homeView()
	{
		logger.infoMessage("Accessed Sign Up view");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("SignUp");
		return mv;
	}

}