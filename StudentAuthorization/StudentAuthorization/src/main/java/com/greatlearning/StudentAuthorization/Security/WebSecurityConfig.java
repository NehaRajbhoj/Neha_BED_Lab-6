package com.greatlearning.StudentAuthorization.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.greatlearning.StudentAuthorization.Service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	public DaoAuthenticationProvider myAuth() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(myUser());
		authProvider.setPasswordEncoder(myPas());
		return authProvider;
	}

	@Bean
	public BCryptPasswordEncoder myPas() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService myUser() {
		return new UserDetailsServiceImpl();
	}

	@SuppressWarnings({ "deprecation", "removal" })
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests().requestMatchers("/", "/students/save", "/students/showFormForAdd", "/students/403")
				.hasAnyAuthority("USER", "ADMIN").requestMatchers("/students/showFormForUpdate", "/students/delete")
				.hasAuthority("ADMIN").anyRequest().authenticated().and().formLogin().loginProcessingUrl("/login")
				.successForwardUrl("/students/list").permitAll().and().logout().logoutSuccessUrl("/login").permitAll()
				.and().exceptionHandling().accessDeniedPage("/students/403").and().cors().and().csrf().disable();

		http.authenticationProvider(myAuth());

		return http.build();
	}
}
