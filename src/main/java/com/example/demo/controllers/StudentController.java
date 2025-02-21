package com.example.demo.controllers;


import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
 
import com.example.demo.entities.Student;
import com.example.demo.repos.StudentDao;
import com.example.demo.service.StudentService;
 
@RestController
public class StudentController {
 
	@Autowired
	StudentService service;
	
	
	@GetMapping("/Students")
	public Iterable<Student> getStudents(){
		return service.getStudents();
	}
	
	 @GetMapping("/Students/{rollNo}")
	 public Optional<Student> getStudentById(@PathVariable int rollNo){
		return service.getStudentById(rollNo);
		
	 }
	
	 @PostMapping("/Students")
	 public String insertStudents(@RequestBody Student s){
		 service.insertStudents(s);
		 return "Added new Student Successfully !";
	 }
	
	 @RequestMapping(path = "/update/{rollNo}",method = {RequestMethod.PUT,RequestMethod.PATCH})
	 public String updateStudent(@RequestBody Student s, @PathVariable int rollNo ) {
		 service.updateStudent(s, rollNo);
		 return "Updated record successfully";
	 }
	
	 @DeleteMapping("/Students/{id}")
	 public String deleteStudent(@PathVariable int id ) {
		 service.deleteStudent(id);
		 return "Successfully deleted Student record !";
	 }
	 
	
	
	
}
