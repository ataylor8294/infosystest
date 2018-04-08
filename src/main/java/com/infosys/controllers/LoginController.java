package com.infosys.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.beans.Account;
import com.infosys.beans.Auth;
import com.infosys.dao.AccountDao;

//rest controller explained in accountcontroller
@RestController
//specifies root path for any requests to the entire controller
@RequestMapping("/login")
public class LoginController {
	//Post mapping immediately declares the methos as a post http call
	//consume MEdiaType JSON allows the method to properly read in json values
	//in the request body
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	// Reads in values in the ajax request into an Auth object
	//Method checks the input from the client side on the database
	//returns user object for cookie creation if successful returns unauthorized or bad request if no username is sent
	public ResponseEntity postUser(@RequestBody Auth input) {
		//converts body to a new object to check proper values
		Auth user = input;
		//System.out.println(user.getUsername()+user.getPassword());
		//AccountDao object created to call its instance methods
		AccountDao accountdb = new AccountDao();
		//default headers object to place in return in response entity
		HttpHeaders headers = new HttpHeaders();
		//if username is null login cannot be successful, return bad request
		if (user.getUsername()==null) {
			return new ResponseEntity("username is null", headers, HttpStatus.BAD_REQUEST);
		}
		// get account retriever username if a user is found with the same username
		Auth indb = accountdb.getAccount(user.getUsername());
		//if no usernmae is found login is unsuccessful
		if (indb==null) {
			return new ResponseEntity("invalid credentials", headers, HttpStatus.UNAUTHORIZED);
		}
		//if username is found the password provided by client and the one found by databas eare compared in final check
		else {
			//if equal user object is returned for storage on the browser cookie
			if(indb.getPassword().equals(input.getPassword())) {
		    	  Account retUser = accountdb.getUser(user.getUsername());
		      return new ResponseEntity(retUser, headers, HttpStatus.ACCEPTED);
		    }
		}
		//returns uunauthoriized if passwords are not equal
		return new ResponseEntity(null, headers, HttpStatus.UNAUTHORIZED);
		
		
		
	}
	
}
