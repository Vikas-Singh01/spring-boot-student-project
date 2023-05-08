package com.qsp.springbootcrudstudentproject.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.qsp.springbootcrudstudentproject.bean.AuthenticationRequest;
import com.qsp.springbootcrudstudentproject.bean.AuthenticationResponse;
import com.qsp.springbootcrudstudentproject.bean.RegisterRequest;
import com.qsp.springbootcrudstudentproject.bean.Role;
import com.qsp.springbootcrudstudentproject.bean.User;
import com.qsp.springbootcrudstudentproject.repositery.UserRepositery;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

	
	private final UserRepositery repositery;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;
	
	public AuthenticationResponse register(RegisterRequest request) {
		var user=User.builder()
				.firstName(request.getFirstName())
				.lastName(request.getLastName())
				.email(request.getEmail())
				.password(passwordEncoder.encode(request.getPassword()))
				.role(Role.USER)
				.build();
		
		repositery.save(user);
		
		var jwtToken=jwtService.generateToken(user);
		return AuthenticationResponse.builder()
				.token(jwtToken).build();
	}
	
	
public AuthenticationResponse authenticate(AuthenticationRequest request) {
		
	authenticationManager.authenticate(
		new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
	
	var user=repositery.findByEmail(request.getEmail())
			.orElseThrow();
	
	var jwtToken=jwtService.generateToken(user);
	
	return AuthenticationResponse.builder()
			.token(jwtToken).build();
	
	}
}
