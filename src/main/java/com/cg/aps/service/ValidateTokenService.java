package com.cg.aps.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.aps.exception.InvalidUserException;
import com.cg.aps.jwt.JwtTokenUtil;

import io.jsonwebtoken.SignatureException;

@Service
public class ValidateTokenService {


	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	public void validateToken(HttpServletRequest request) {
		final String tokenHeader = request.getHeader("Authorization");

		String jwtToken = null;

		if (tokenHeader == null)
			throw new InvalidUserException("User Not Logged In or token not included");
		// JWT Token is in the form "Bearer token". Remove Bearer word
		if (!tokenHeader.startsWith("Bearer "))
			throw new InvalidUserException("Invalid Token");
		jwtToken = tokenHeader.substring(7);
//		System.out.println("**********"+jwtTokenUtil.getRoleFromToken(jwtToken));
//		if (!jwtTokenUtil.getRoleFromToken(jwtToken).equals(role)) {
//			throw new InvalidUserException("Not authorized to perfrom this action");
//		}
		
		jwtToken = tokenHeader.substring(7);
		try {
			if (!(jwtTokenUtil.validateToken(jwtToken)))
				throw new InvalidUserException("Token Expired. Need Relogin");

		} catch (SignatureException ex) {
			throw new InvalidUserException("Invalid Token");
		}
	}

}


