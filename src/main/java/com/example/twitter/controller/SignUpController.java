package com.example.twitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.twitter.dto.UserDto;
import com.example.twitter.service.SignUpService;



@RestController
@RequestMapping("/signup")
public class SignUpController {
	@Autowired
	private SignUpService signUpService;
	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody UserDto user) {
//	     return userServiceImpl.createUser(user);
//	     return new ResponseEntity<>(user1,HttpStatus.CREATED);
	     UserDto createdUser = signUpService.createUser(user);
	        if (createdUser != null) {
	            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
	        } else {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create customer");
	      }
		
		
	}

}
