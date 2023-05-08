package com.qsp.springbootcrudstudentproject.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.qsp.springbootcrudstudentproject.dto.Student;
import com.qsp.springbootcrudstudentproject.repositery.StudentRepositery;

@Repository
public class StudentDao {
	
	@Autowired
	StudentRepositery studentRepositery;

	public void insertStudent(Student student) {
		studentRepositery.save(student);
	}

	public int getById(int id) {
		Optional<Student> optional = studentRepositery.findById(id);
		if (optional.isPresent()) {
			return optional.get().getId();
		} else {
			return 0;
		}
	}

	public Student getStudentById(int id) {
		Optional<Student> optional = studentRepositery.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	public void updateStudent(int id, Student student) {

		Optional<Student> optional = studentRepositery.findById(id);
		Student student2 = optional.get();

		if (student.getName() != null) {
			student2.setName(student.getName());
			studentRepositery.save(student2);
		} else if (student.getGenderString() != null) {
			student2.setGenderString(student.getGenderString());
			studentRepositery.save(student2);
		} else if ((student.getName() != null) && (student.getGenderString() != null))

		{
			student2.setName(student.getName());
			student2.setGenderString(student.getGenderString());
			studentRepositery.save(student2);
		}
	}

	public void deleteStudent(int id) {

		Optional<Student> optional = studentRepositery.findById(id);
		Student student = optional.get();
		if (optional.isPresent()) {
			studentRepositery.delete(student);
		}
	}

	public Page<Student> displayStudents(int pageNumber, int pageSize) {

		return studentRepositery.findAll(PageRequest.of(pageNumber, pageSize));
		
	}
	
	public List<Student> findByNameAndGenderString(String name, String genderString) {
		return studentRepositery.findByNameAndGenderString(name, genderString);
	}

	public List<Student> getUserByNameAndGenderString(String name, String genderString) {
		return studentRepositery.getUserByNameAndGenderString(name, genderString);
	}
	
	public List<Student> getAllUsers() {
		return studentRepositery.getAllUsers();
	}

	public List<Student> getStudentsWithR(){
		return studentRepositery.getStudentsWithR();
	}
	
	public Long countAllStudents()
	{
		return studentRepositery.count();
	}
	
	public List<Student> sortByName(String name){
		return studentRepositery.findAll(Sort.by(Sort.Direction.ASC,name));
	}
}
