package com.qsp.springbootcrudstudentproject.repositery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.qsp.springbootcrudstudentproject.dto.Student;

public interface StudentRepositery extends JpaRepository<Student, Integer>
{
	
//	using custom methods, operators can be seen in spring documentation , method name should be genuine with consists of same variable name as in entities.
	public List<Student> findByNameAndGenderString(String name,String genderString);
		
//	using JPQL query , method name should be genuine with consists of same variable name as in entities.
	@Query("SELECT s FROM Student s WHERE s.name =:anything and s.genderString =:gender")
	public List<Student> getUserByNameAndGenderString(@Param("anything") String name, @Param("gender") String genderString);

// using native query,method name should be genuine with consists of same variable name as in entities.
	@Query(value =  "SELECT * FROM Student" , nativeQuery = true)
	public List<Student> getAllUsers();
	
//	to get students whose name starts with R
	@Query(value = "SELECT * FROM Student WHERE name LIKE 'R%' ", nativeQuery = true)
	public List<Student> getStudentsWithR(); 
}


