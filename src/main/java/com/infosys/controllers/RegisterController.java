package com.infosys.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.beans.Account;
import com.infosys.beans.Auth;
import com.infosys.dao.AccountDao;

@RestController
@RequestMapping("/register")
public class RegisterController {
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity newUser(@RequestBody Account input) {
		Account test = input;
		HttpHeaders http = new HttpHeaders();
		AccountDao accountdao = new AccountDao();
		System.out.println(test.getUsername());
		if (test.getUsername()==null ||test.getPassword()==null||test.getFirstname()==null|| test.getLastname()==null){
			return new ResponseEntity(null, http, HttpStatus.UNAUTHORIZED);
		}
		// get account retriever username if a user is found with the same username
		Auth indb = accountdao.getAccount(test.getUsername());
		//if no usernmae is found login is unsuccessful
		if (indb!=null) {
				return new ResponseEntity("username is taken", http, HttpStatus.UNAUTHORIZED);
		}
		//if username is found the password provided by client and the one found by databas eare compared in final check
		else {
		//if equal user object is returned for storage on the browser cookie
				accountdao.saveAccount(test);
				return new ResponseEntity(null, http, HttpStatus.ACCEPTED);
			}
	}
}
