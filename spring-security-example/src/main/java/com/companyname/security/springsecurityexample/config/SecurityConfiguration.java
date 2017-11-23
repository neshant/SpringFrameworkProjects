package com.companyname.security.springsecurityexample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	// @formatter:off
	protected void configure(HttpSecurity httpSecurity) throws Exception {
	
		
//1.		//the control of request is being done here 
//		httpSecurity.authorizeRequests()
//				 .antMatchers("*/hello/").hasRole("USER")
//				.anyRequest()
//				.fullyAuthenticated().and()
//						.httpBasic();

		// cross site scripting disabled
		
		
//2. The control is pushed towards filter
		
		httpSecurity.authorizeRequests()
.anyRequest().fullyAuthenticated()
		.and()
		//.addFilterBefore(customFilter(), BasicAuthenticationFilter.class)
		.httpBasic();
		
		
		
		httpSecurity.csrf().disable();
	}

	@Bean
	public CustomFilter customFilter() {
		return new CustomFilter(); 
	}

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()  /// can use custom authentication as well from database and passwird
		.withUser("neshant").password("test").roles("ADMIN").and().withUser("mayank")
				.password("apple").roles("USER");
	}

}
