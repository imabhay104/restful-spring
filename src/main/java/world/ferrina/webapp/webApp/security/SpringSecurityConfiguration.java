package world.ferrina.webapp.webApp.security;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
	//InMemoryUserDetailsManager(UserDetails...details users);
	
	 @Bean
	    public InMemoryUserDetailsManager createUserDetailsManager() {
	        // Injecting PasswordEncoder as a parameter
	        UserDetails userDetails1 = createUser( "admin", "admin");
	        UserDetails userDetails2 = createUser("user", "user");
	        return new InMemoryUserDetailsManager(userDetails1,userDetails2);
	    }

	private UserDetails createUser(String username, String password) {
		Function<String,String> passwordEncoder = i->passwordEncoder().encode(i); 
		
		UserDetails userDetails = User.builder()
		        .passwordEncoder(passwordEncoder) // Use the injected encoder
		        .username(username)
		        .password(password)
		        .roles("USER", "ADMIN")
		        .build();
		return userDetails;
	}

	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	    
	    
	    @Bean
	    public SecurityFilterChain filerChain(HttpSecurity http) throws Exception
	    {
	    	http.authorizeHttpRequests(auth->auth.anyRequest().authenticated());
	    	http.formLogin(withDefaults());
	    	http.csrf().disable();
	    	http.headers().frameOptions().disable();
	    	return http.build();
	    	
	    }
	    
	}