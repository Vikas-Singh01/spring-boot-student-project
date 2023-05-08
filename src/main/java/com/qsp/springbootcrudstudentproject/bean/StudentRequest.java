package com.qsp.springbootcrudstudentproject.bean;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Validated
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {

	
	@JsonProperty("name")
	private String name;
	
	
	@JsonProperty("gender")
	private String genderString;
	
}
