package com.qsp.springbootcrudstudentproject.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springbootcrudstudentproject.dto.Subjects;
import com.qsp.springbootcrudstudentproject.repositery.SubjectRepositrey;

@Repository
public class SubjectDao {

	@Autowired
	SubjectRepositrey subjectRepositery;
	
	
	public void createSubject(Subjects subjects){
		subjectRepositery.save(subjects);
			
	}
	
}
