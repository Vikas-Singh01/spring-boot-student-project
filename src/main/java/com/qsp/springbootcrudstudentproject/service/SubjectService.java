package com.qsp.springbootcrudstudentproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.springbootcrudstudentproject.dao.ResponseStructure;
import com.qsp.springbootcrudstudentproject.dao.SubjectDao;
import com.qsp.springbootcrudstudentproject.dto.Subjects;

@Service
public class SubjectService {

	@Autowired
	SubjectDao subjectDao;
	
	
	@Autowired
	ResponseStructure response;
	
	
	public ResponseEntity<ResponseStructure> createSubject(Subjects subjects){
		subjectDao.createSubject(subjects);
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setMsg(HttpStatus.CREATED.name());
		response.setData(subjects);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

}
