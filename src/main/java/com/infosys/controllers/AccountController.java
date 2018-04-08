package com.infosys.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


//Simple example of how spring mvc map uri locations to request and responses
//Rest controller annotation adds response body annotation to default controller
//Sets the bean as a controller in mvc and adds automatically response body to all the methods
@RestController
public class AccountController {
		
	//Request mapping specifies the uri destinations
	//These methods return strings that will be displayed in the browser on entering location
		@RequestMapping("/a")
		public String hello() {
			return "hello from Spring Boot";
		}
		
		@RequestMapping("/whatever")
		public String whatever(){
			return "that doesnt mean anything";
		}
		@RequestMapping("/welcome")
		public String welcome() {
			return "Welcome!";
		}
		

		
}
