package com.qsp.springbootcrudstudentproject.dao;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class ResponseStructure 
{
	private int statusCode;
	private String msg;
	private Object data;
	
	
	
	
}
