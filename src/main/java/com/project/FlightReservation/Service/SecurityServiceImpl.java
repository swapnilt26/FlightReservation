package com.project.FlightReservation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService {

	@Autowired
	UserDetailsService userService;
	
	@Autowired
	AuthenticationManager manager;
	
	@Override
	public boolean login(String username, String password) {
		UserDetails details = userService.loadUserByUsername(username);
		
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(details, password, details.getAuthorities());
		
		manager.authenticate(token);
		
		boolean authenticated = token.isAuthenticated();
		
		if(authenticated)
		{
			SecurityContextHolder.getContext().setAuthentication(token);  //Spring will store this information just like session
																		  //so that it will not keep on asking about username password 
		}																  //again or do not push for login repeatedly	
			
		return authenticated;
	}

}
