package com.qsp.springbootcrudstudentproject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.springbootcrudstudentproject.bean.AuthenticationRequest;
import com.qsp.springbootcrudstudentproject.bean.AuthenticationResponse;
import com.qsp.springbootcrudstudentproject.bean.RegisterRequest;
import com.qsp.springbootcrudstudentproject.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

	private final AuthenticationService service;
	
	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(
			@RequestBody RegisterRequest request){
	
		return ResponseEntity.ok(service.register(request));
	}
	
	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> authenticate(
			@RequestBody AuthenticationRequest request){
		return ResponseEntity.ok(service.authenticate(request));
	}
	
}
