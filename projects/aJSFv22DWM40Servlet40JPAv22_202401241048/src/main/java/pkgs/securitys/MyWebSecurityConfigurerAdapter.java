package pkgs.securitys;

import java.io.Serializable;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class MyWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter implements Serializable {

	private static final long serialVersionUID = 20240310070601L;

	@Bean
	public MyUserDetailsService userDetailsService() {
		return new MyUserDetailsService();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
				.csrf().disable()
			.authorizeRequests()
				.antMatchers("/javax.faces.resource/**", "/resources/**", "/Index.xhtml", "/Logar.xhtml", "/Erro.xhtml").permitAll()
				.antMatchers("/LogadoOn01.xhtml").authenticated()
				.antMatchers("/LogadoOn02.xhtml").hasAnyRole("ADMINISTRADORES")
				.antMatchers("/LogadoOn03.xhtml").hasAnyRole("ADMINISTRADORES","VENDEDORES","AUXILIARES")
				.and()
			.formLogin()
				.loginPage("/Logar.xhtml")
				.failureUrl("/Logar.xhtml?invalid=true")
				.and()
			.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))

		;

	}

}
