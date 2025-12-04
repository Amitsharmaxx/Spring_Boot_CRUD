package com.elevate.spring_boot_crud_sql.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringWebSecurity {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpsSecurity) throws Exception {

		httpsSecurity.csrf(csrf -> csrf.disable());
		httpsSecurity.authorizeHttpRequests(
				request -> request.requestMatchers("/employee/**").hasRole("ADMIN").anyRequest().authenticated())
				.formLogin(Customizer.withDefaults());

		return httpsSecurity.build();

	}
	
	
	
	
	
	

}
