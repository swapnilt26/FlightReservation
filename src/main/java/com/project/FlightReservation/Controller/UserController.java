package com.project.FlightReservation.Controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.FlightReservation.Entities.User;
import com.project.FlightReservation.Repository.UserRepository;
import com.project.FlightReservation.Service.SecurityService;

@Controller
public class UserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	SecurityService securityService;
	
	@RequestMapping("/showReg")
	public String userRegistrationPage()
	{
		LOGGER.info("Inside userRegistrationPage() Method");
		return "login/register";
	}

	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerUser(@ModelAttribute("user")User user)
	{
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		LOGGER.info("Inside registerUser() Method with User Info: "+user);
		userRepo.save(user);
		return "login/login";
	}
	
	@RequestMapping(value="/showlogin") 
	public String showLogin()						
	{
		LOGGER.info("Inside showLogin() Method");
		return "login/login";
	}
	
	/*@RequestMapping(value="/login", method=RequestMethod.GET)  // This method ensures that if hit url http://localhost:8080/flightreservation/login
	public String getLogin()								  // then it should still work, otherwise it will throw nullpointer exception
	{
		return "login/login";
	}
	*/
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginUser(@RequestParam("email")String email, @RequestParam("password")String password, ModelMap model, HttpServletRequest req)
	{
		LOGGER.info("Inside loginUser() Method With email as :"+email);
		/*User user=userRepo.findByEmail(email);
		if(user!=null&&user.getPassword().equals(password))
		{	
			LOGGER.info("Inside loginUser() Method where If Condition is true");
			return "findflight";
		}*/
		boolean loginState = securityService.login(email, password);
		if(loginState)
		{
			LOGGER.info("Inside loginUser() Method where If Condition is true");
			return "findflight";
		}
		else
		{	
			LOGGER.info("Inside loginUser() Method where Else Condition is true");
			model.addAttribute("msg", "Ivalid Username or Password, please try again!!");
			return "login/login";
		}
	}
}
