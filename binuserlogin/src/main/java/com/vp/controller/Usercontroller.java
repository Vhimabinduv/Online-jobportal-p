package com.vp.controller;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.vp.model.User;
import com.vp.service.IUserservice;



@RestController

public class Usercontroller {

	@Autowired
	IUserservice userservice;
	
	
	
	Logger logger = LoggerFactory.getLogger(Usercontroller.class);
	
	@GetMapping("/users")
	public List<User> getUsers(){
		
		logger.info("userlist invoked");
		
		logger.debug("missing product.png");
		return userservice.getAllUser();
	}
	
	
	
	
	
	@PostMapping("/user")
	public void insertUser(@Valid @RequestBody User user) {
		
		//logging
		
		
		logger.info("user inserted successfully");
		
	
		userservice.saveUser(user);
	}
	
	
	
}
