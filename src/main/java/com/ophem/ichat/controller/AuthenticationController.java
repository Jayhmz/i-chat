package com.ophem.ichat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ophem.ichat.config.JWTUtility;
import com.ophem.ichat.model.JWTRequest;
import com.ophem.ichat.service.UserService;

@Controller
@RequestMapping("/api/auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JWTUtility utility;

	@GetMapping("/test")
	public ResponseEntity<?> test(){
		
		return ResponseEntity.ok().body("this is working");
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticate(@RequestBody JWTRequest request) throws Exception{
		
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
					);
		} catch (AuthenticationException e) {
			throw new Exception("INVALID CREDENTIALS", e);
		}
		
		final User userdetails = (User) userService.loadUserByUsername(request.getUsername());
		userdetails.eraseCredentials();
		
		final String token = utility.generateToken(userdetails);
		
		
		return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, token).body(userdetails);
		
	}
	
	@GetMapping("/sos")
	public ResponseEntity<String> secureTest(){
		return new ResponseEntity<String>("this is working great",HttpStatus.OK);
	}
	
	
}
