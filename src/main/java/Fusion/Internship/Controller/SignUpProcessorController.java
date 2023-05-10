package Fusion.Internship.Controller;

import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Fusion.Internship.Model.User;
import Fusion.Internship.Service.HomeService;
import Fusion.Internship.Service.LoggerService;

@Controller
@RequestMapping(value = { "/welcome" })
public class SignUpProcessorController {
	
	@Autowired
	HomeService service;
	
	@Autowired
	LoggerService logger;
	
	@PostMapping
	public ModelAndView homeView(@RequestParam(name = "email")            					String email,
								 @RequestParam(name = "password")        					String password, 
								 @RequestParam(name = "passwordRetyped")  					String passwordRetyped,
								 @RequestParam(name = "gender", required = false)           String gender,
								 @RequestParam(name = "age", required = false)              Integer age,
								 @RequestParam(name = "securityQuestion", required = false) String securityQuestion,
								 @RequestParam(name = "securityAnswer", required = false)   String securityAnswer,
								 HttpSession session) throws SQLException
	{	
		
		ModelAndView mv = new ModelAndView();
		User newUser;
		String userEmail = email;
		String userPassword = password;
		String userGender = gender;
		Integer userAge = age;
		String userSecurityQuestion = securityQuestion;
		String userSecurityAnswer = securityAnswer;
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		//Password requirements?
		
		//Check to see if user already exists
		if(service.getUser(email) != null) {
			logger.infoMessage("Sign Up: Attempted to sign up with existing email!");
			mv.setViewName("SignUp");
			mv.addObject("error", "User already exists!");
			return mv;
		}
		
		if(userEmail == null || userPassword == null || passwordRetyped == null) {
			logger.infoMessage("Sign Up: Attempted to sign up without necessary fields!");
			mv.setViewName("SignUp");
			mv.addObject("error", "Nececessary fields left empty.");
		}
		
		//Check passwords match
		if(!password.contentEquals(passwordRetyped)) {
			logger.infoMessage("Sign Up: Attempted to sign up without matching passwords!");
			mv.setViewName("SignUp");
			mv.addObject("error", "Passwords do not match!");
			return mv;
		}
		
		//if Question or Answer left blank, set both to null as default and continue processing
		if(userSecurityQuestion.contentEquals("") || userSecurityAnswer.contentEquals("")) {
			userSecurityQuestion = null;
			userSecurityAnswer = null;
		}
		
		//Age must be valid entry if provided
		if(age != null && age <= 0) {
			logger.infoMessage("Sign Up: ");
			mv.setViewName("SignUp");
			mv.addObject("error", "Age is invald. This is field is optional.");
			return mv;
		}
		
		newUser = new User(0, userEmail, userPassword, timestamp, false, userAge, userGender, userSecurityQuestion, userSecurityAnswer);
		service.createUser(newUser);
		mv.setViewName("Home");
		mv.addObject("error", "Welcome! Please sign in.");
		logger.infoMessage("Home: Successful Sign Up");
		return mv;
	}

}
