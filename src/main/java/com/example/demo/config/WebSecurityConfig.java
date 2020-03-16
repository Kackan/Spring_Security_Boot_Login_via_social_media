package com.example.demo.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;


@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests(authorizeRequest->authorizeRequest.antMatchers("/","/error","/webjars/**")
				//it enables running javaScript for all visitors /webjars/** 
				.permitAll().anyRequest().authenticated())
//		.formLogin().successH("/hello")
//		.and()
		.exceptionHandling(exceptionHandling->exceptionHandling
				.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
		.csrf(csrf->csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
		.logout(logout->logout.logoutSuccessUrl("/").logoutUrl("/logout").permitAll()).oauth2Login(o -> o
	            .failureHandler(new MyOwnFailureHandler())
	        );
	}
}