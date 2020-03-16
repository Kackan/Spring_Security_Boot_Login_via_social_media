package com.example.demo.controller;

import java.security.Principal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainController {
	
	@GetMapping("/user")
	public Principal user(Principal principal)
	{
		System.out.println("User:");
		System.out.println(principal.toString());		
		return principal;
	}
	
	@GetMapping("/hello")
	public String hello()
	{
		return "Hello!";
	}
	
	@GetMapping("/error")
	public String error()
	{
		return "Error";
	}
	
}
