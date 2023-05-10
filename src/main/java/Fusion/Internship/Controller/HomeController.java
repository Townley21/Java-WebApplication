package Fusion.Internship.Controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import Fusion.Internship.Service.LoggerService;

@Controller
@RequestMapping(value = { "/" })
public class HomeController {
	
	@Autowired
	LoggerService logger;
	
	@GetMapping
	public ModelAndView homeView(HttpSession session)
	{
		
		logger.infoMessage("Home");
		ModelAndView model = new ModelAndView();

		model.setViewName("Home");
		session.setAttribute("loggedin", false);
		
		return model;
		
		
	}

}
