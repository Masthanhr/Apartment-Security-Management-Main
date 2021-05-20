package com.cg.aps.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.aps.exception.InvalidUserException;
import com.cg.aps.jwt.JwtTokenUtil;
import com.cg.aps.entities.UserEntity;
import com.cg.aps.repository.AuthenticationRepository;
@Service
public class AuthenticationService {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private AuthenticationRepository authenticationRepository;

	public String createAuthenticationToken(UserEntity user) throws Exception {

		System.out.println("User Object" + user);
		Optional<UserEntity> userData = authenticationRepository.findById(user.getUserId());
		System.out.println("User Data *****" + userData);
		if (userData.isPresent()) {
			user = userData.get();
		} else {
			throw new InvalidUserException("User not found with username: " + user.getUserId());
		}

		if (!(user.getPassword().equals(user.getPassword())))
			throw new InvalidUserException("Invalid Password");

		String token = jwtTokenUtil.generateToken(user);

		return token;
		
	}

}

 


