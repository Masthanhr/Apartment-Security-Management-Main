package com.cg.aps.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.aps.jwt.JwtRequest;
import com.cg.aps.jwt.JwtResponse;
import com.cg.aps.entities.UserEntity;
import com.cg.aps.service.AuthenticationService;

@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authenticationService;

	UserEntity user;

	// login
	@PostMapping
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest request) throws Exception {
        // I am converting JWTRequest User Object
		UserEntity user = new UserEntity(request.getUserId(), request.getPassword());
	
		String token = authenticationService.createAuthenticationToken(user);
	
		return ResponseEntity.ok(new JwtResponse(token));
	
	}
}
