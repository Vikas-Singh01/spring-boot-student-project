package com.qsp.springbootcrudstudentproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.springbootcrudstudentproject.bean.StudentRequest;
import com.qsp.springbootcrudstudentproject.dao.ResponseStructure;
import com.qsp.springbootcrudstudentproject.dto.Student;
import com.qsp.springbootcrudstudentproject.exception.IdNotFoundException;
import com.qsp.springbootcrudstudentproject.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController 
{
	@Autowired
	StudentService studentService;
	
	@PostMapping("/insertStudent")
	public ResponseEntity<ResponseStructure> insertStudent(@RequestBody StudentRequest studentRequest)
	{
			return	studentService.insertStudent(studentRequest);

	}
	@GetMapping("/getById/{id}")
	public int getById(@PathVariable int id)
	{
		return studentService.getById(id);
	}
	
	@GetMapping("/getStudent/{id}")
	public Student getStudentById(@PathVariable int id)
	{
		return studentService.getStudentById(id);
	}
	
	@PutMapping("/updateStudent/{id}")
	public String updateStudent(@PathVariable int id,@RequestBody Student student) throws IdNotFoundException {
	
			studentService.updateStudent(id, student);	
			return "data updated successfully";
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable int id) {
		return studentService.deleteStudent(id);
	}
	
	@GetMapping("/displayStudents/{pageNumber}/{pageSize}")
	public Page<Student> displayStudents(@PathVariable int pageNumber,@PathVariable int pageSize) {
		return studentService.displayStudents(pageNumber,pageSize);
	}
	
	@GetMapping("/findByNameAndGenderString/{name}/{genderString}")
	public List<Student> findByNameAndGenderString(@PathVariable String name,@PathVariable String genderString){
		return studentService.findByNameAndGenderString(name, genderString);
	}
	
	@GetMapping("/getUserByNameAndGenderString/{name}/{genderString}")
	public List<Student> getUserByNameAndGenderString(@PathVariable String name,@PathVariable String genderString){
		return studentService.getUserByNameAndGenderString(name, genderString);
	}
	
	@GetMapping("/getAllUsers")
	public List<Student> getAllUsers() {
		return studentService.getAllUsers();
	}
	
	@GetMapping("/getUsersWithR")
	public List<Student> getStudentsWithR(){
		return studentService.getStudentsWithR();
	}
	
	@GetMapping("/countStudents")
	public Long countAllStudents()
	{
		return studentService.countAllStudents();
	}
	
	@GetMapping("/sortByNmae/{name}")
	public List<Student> sortByName(@PathVariable String name){
		return studentService.sortByName(name);
	}
}
