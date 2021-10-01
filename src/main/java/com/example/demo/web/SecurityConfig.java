package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public BCryptPasswordEncoder encriptarClave() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	private void configureGlobal(AuthenticationManagerBuilder build) throws Exception {
		build.userDetailsService(userDetailsService).passwordEncoder(encriptarClave());
	}

	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/actualizar/**", "/guardar/**", "/eliminar")
		.hasRole("ADMIN")
		.antMatchers("/")
		.hasAnyRole("USER","ADMIN","GUESS")
		.and()
		.formLogin()
		.loginPage("/login")
		.and()
		.exceptionHandling()
		.accessDeniedPage("/login");
	}

}
