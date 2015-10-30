package trainingapp.training;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomAuthentificationSuccessHandler implements  AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res, Authentication auth)
			throws IOException, ServletException {
		Collection<? extends GrantedAuthority> roles = auth.getAuthorities();
		
		if(roles.size() == 1 && roles.contains(new SimpleGrantedAuthority("VENDEUR"))){
			res.setStatus(HttpServletResponse.SC_OK);
			res.sendRedirect("user/vendeur");
		}else if(roles.size() == 1 && roles.contains(new SimpleGrantedAuthority("ACHETEUR"))){
			res.setStatus(HttpServletResponse.SC_OK);
			res.sendRedirect("user/acheteur");
		}else{
			throw new RuntimeException("Role Incorrect");
		}
	}

}
