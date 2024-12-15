package world.ferrina.webapp.webApp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import world.ferrina.webapp.webApp.security.SpringSecurityConfiguration;

@Controller
@SessionAttributes("name")
public class WelcomeController {

//	private AuthenticationService service;
//
//	public LoginController(AuthenticationService service) {
//		super();
//		this.service = service;
//	}

	// get method
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goToWelcomePage(ModelMap model) {
		model.put("name",getLoggedInUsername());
		return "Welcome";
	}
	
	private String getLoggedInUsername()
	{
		Authentication authenticaion = SecurityContextHolder.getContext().getAuthentication();
		return authenticaion.getName();
	}
	
	
	
	// post method
//	@RequestMapping(value = "login", method = RequestMethod.POST)
//	public String WelcomePage(@RequestParam String name, @RequestParam String pass, ModelMap model) {
//		if (service.authenticate(name, pass)) {
//			model.put("name", name);	
//
//			return "Welcome";
//		} else {
//			model.put("errorMessage", "Inavalid Creds");
//			return "login";
//		}
//	}

}
