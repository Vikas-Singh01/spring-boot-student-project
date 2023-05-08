package com.qsp.springbootcrudstudentproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.springbootcrudstudentproject.bean.StudentRequest;
import com.qsp.springbootcrudstudentproject.dao.ResponseStructure;
import com.qsp.springbootcrudstudentproject.dao.StudentDao;
import com.qsp.springbootcrudstudentproject.dto.Student;
import com.qsp.springbootcrudstudentproject.exception.IdNotFoundException;

@Service
public class StudentService {
	@Autowired
	StudentDao studentDao;

	@Autowired
	ResponseStructure response;
	
	public ResponseEntity<ResponseStructure> insertStudent(StudentRequest studentRequest) {
		
		String studentName=studentRequest.getName();
		String studentGender=studentRequest.getGenderString();
		Student student=new Student();
		student.setName(studentName);
		student.setGenderString(studentGender);
		studentDao.insertStudent(student);
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setMsg(HttpStatus.CREATED.name());
		response.setData(studentRequest);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
		
	}

	public int getById(int id) {
		return studentDao.getById(id);
	}

	public Student getStudentById(int id) {
		return studentDao.getStudentById(id);
	}

	public void updateStudent(int id, Student student) throws IdNotFoundException {

		if (studentDao.getStudentById(id) != null) {
			studentDao.updateStudent(id, student);

		} else {
	
			throw new IdNotFoundException("Id is not present");
		}
	}

	public String deleteStudent(int id) {

		if (studentDao.getStudentById(id) != null) {
			studentDao.deleteStudent(id);
			return "data deleted";
		} else {
			return "id is not present";
		}
	}

	public Page<Student> displayStudents(int pageNumber,int pageSize) {

		return studentDao.displayStudents(pageNumber,pageSize);
	}

	public List<Student> findByNameAndGenderString(String name, String genderString) {
		return studentDao.findByNameAndGenderString(name, genderString);
	}

	public List<Student> getUserByNameAndGenderString(String name, String genderString) {
		return studentDao.getUserByNameAndGenderString(name, genderString);
	}

	public List<Student> getAllUsers() {
		return studentDao.getAllUsers();
	}
	
	public List<Student> getStudentsWithR(){
		return studentDao.getStudentsWithR();
	}
	
	public Long countAllStudents() {
		return 	studentDao.countAllStudents();
		
	}
	public List<Student> sortByName(String name){
		return studentDao.sortByName(name);
	}


}
