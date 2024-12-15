package world.ferrina.webapp.webApp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	public boolean authenticate(String username,String pass)
	{
		boolean isValidUsername = username.equalsIgnoreCase("admin");
		boolean isValidPassword = pass.equalsIgnoreCase("admin");
			return isValidPassword && isValidPassword;
	}
	
}
