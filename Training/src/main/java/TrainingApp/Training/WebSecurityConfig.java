package trainingapp.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

import trainingapp.training.service.UtilisateurService;

@Configuration
@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Lazy
	@Autowired
	UtilisateurService utilisateurService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();

		http.authorizeRequests()
				.antMatchers("/", "/home", "/user/create/acheteur", "/user/create", "/user/create/vendeur").permitAll()
				.anyRequest().authenticated().and().formLogin()
				.successHandler(new CustomAuthentificationSuccessHandler())
				// .formLogin().defaultSuccessUrl("/user", true)
				// .loginPage("/login")
				.permitAll().and().logout().logoutSuccessUrl("/").permitAll();

		http.exceptionHandling().accessDeniedPage("/error/accessDenied");

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		super.configure(web);
		web.ignoring().antMatchers("/ressources/**");
		web.ignoring().antMatchers("/assets/**");
	}

	@Autowired
	public void configureGlobal(final AuthenticationManagerBuilder auth) {
		try {
			auth.userDetailsService(this.utilisateurService);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}