package com.fis.FisFirstTestCase.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig{
	
	 @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        http
	            .authorizeHttpRequests(auth -> auth
	                .requestMatchers("/actuator/**").permitAll() // allow actuator endpoints
	                .anyRequest().authenticated()               // all other endpoints require auth
	            )
	            .httpBasic(Customizer.withDefaults())           // basic auth
	            .csrf(csrf -> csrf.disable());                  // disable CSRF for APIs

	        return http.build();
	    }
}
