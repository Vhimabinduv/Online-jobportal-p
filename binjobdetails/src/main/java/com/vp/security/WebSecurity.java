package com.vp.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	
	@Value("${spring.security.user.name}")
	private String username;
	
	@Value("${spring.security.user.password}")
	private String password;
	
	
	 

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http.httpBasic().and().authorizeRequests()
		.antMatchers("/security/**").hasRole("ADMIN")
		.and().csrf().disable();
		//super.configure(http);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
		//String password=passwordEncoder().encode("bindu123");
		auth.inMemoryAuthentication().withUser("bindu").password(password).roles("ADMIN");
		
	}
	@Bean
public PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
}

	
}
