package com.qsp.springbootcrudstudentproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.springbootcrudstudentproject.dao.ResponseStructure;
import com.qsp.springbootcrudstudentproject.dto.Subjects;
import com.qsp.springbootcrudstudentproject.service.SubjectService;

@RestController
@RequestMapping("/subject")
public class SubjectController {

	@Autowired
	SubjectService subjectService;
	
	
	@PostMapping("/createSubject")
	public ResponseEntity<ResponseStructure> createSubject(@RequestBody Subjects subjects){
	return	subjectService.createSubject(subjects);
	}

}
