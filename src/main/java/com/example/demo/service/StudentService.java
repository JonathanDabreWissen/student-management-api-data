package com.example.demo.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Student;
import com.example.demo.repos.StudentDao;


@Service
public class StudentService {
	@Autowired
	StudentDao dao;
	
	public Iterable<Student> getStudents(){
		return dao.findAll();
	}
	
	public Optional<Student> getStudentById(int rollNo){
		return dao.findById(rollNo);
		
	}
	
	public String insertStudents(Student s){
		if(dao.existsById(s.getRollNo())) {
			return "sorry the Student already exists, choose another Roll No";
		}
		dao.save(s);
		return "Added new Student Successfully !";
	}
	
	public String updateStudent(Student s, int rollNo ) {
		 if(!dao.existsById(rollNo)) {
			 return "sorry the Student does not exists, choose another ID to update";
		 }
		 dao.save(s);
		 return "Updated record successfully";
	 }
	
	 public String deleteStudent(int rollNo ) {
		 if(!dao.existsById(rollNo)) {
			 return "sorry the Student does not exists, choose another ID to delete";
		 }
		 dao.deleteById(rollNo);
		 return "Successfully deleted Student record !";
	 }
	
}