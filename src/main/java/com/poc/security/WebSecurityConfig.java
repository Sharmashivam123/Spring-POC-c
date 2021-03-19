package com.poc.security;

import java.util.logging.Logger;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	private static Logger logger = Logger.getLogger(WebSecurityConfig.class.getName());
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		logger.info("inside configuration");
		http.csrf().disable().authorizeRequests().antMatchers("/login*", "/*").permitAll().anyRequest().authenticated().and().formLogin().loginPage("/login");
		
		logger.info("header set");
		http.headers().frameOptions().disable();
		
		logger.info("going out");
	}
}
