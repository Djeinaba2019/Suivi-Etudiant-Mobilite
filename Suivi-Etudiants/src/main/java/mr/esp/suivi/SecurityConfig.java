package mr.esp.suivi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/* cette classe à pour but de configurer l' authentification avec Spring Security */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
	
		auth.inMemoryAuthentication().withUser("18015.mamadou.aly@esp.mr").password("123").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("teguedi").password("123").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("biha").password("123").roles("PROF");
		auth.inMemoryAuthentication().withUser("baba").password("123").roles("PROF");
		auth.inMemoryAuthentication().withUser("etudiant1").password("123").roles("ETUDIANTE");
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.authorizeRequests()
				.antMatchers("/css/**", "/js/**", "/images/**", "/assets/**" , "/fonts/**", "/vendor/**")
					.permitAll()
				.anyRequest()
					.authenticated()
					.and()
			.formLogin()
				.loginPage("/login.html")
					.permitAll()
						.defaultSuccessUrl("/Mobilite.html");
		/* restes à créer des étudiants dans la base */
	}
}
