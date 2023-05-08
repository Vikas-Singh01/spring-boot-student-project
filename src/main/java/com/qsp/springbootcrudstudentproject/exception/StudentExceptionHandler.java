package com.qsp.springbootcrudstudentproject.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.qsp.springbootcrudstudentproject.dao.ResponseStructure;

@ControllerAdvice
public class StudentExceptionHandler {

	
	@Autowired
	ResponseStructure responseStructure;
	
	@ExceptionHandler(value = IdNotFoundException.class)
	public ResponseEntity<ResponseStructure> noIdFound(IdNotFoundException exception)
	{
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMsg("Data is not available");
		responseStructure.setData(exception.getMessage());
		
//		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND.OK);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseStructure);
	}
}
