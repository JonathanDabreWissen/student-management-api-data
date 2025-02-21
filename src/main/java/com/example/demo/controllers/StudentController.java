package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	StudentService service;

	@GetMapping
	public Iterable<Student> getStudents() {
		return service.getStudents();
	}

	@GetMapping("/{rollNo}")
	public Optional<Student> getStudentById(@PathVariable int rollNo) {
		return service.getStudentById(rollNo);
	}

	@PostMapping
	public String insertStudents(@RequestBody Student s) {
		return service.insertStudents(s);
	}

	@PutMapping("/update/{rollNo}")
	public String updateStudent(@RequestBody Student s, @PathVariable int rollNo) {
		return service.updateStudent(s, rollNo);
	}

	@DeleteMapping("/{rollNo}")
	public String deleteStudent(@PathVariable int rollNo) {
		return service.deleteStudent(rollNo);
	}

	// Get all students from a specific school
	@GetMapping("/school")
	public List<Student> getStudentsBySchool(@RequestParam String name) {
		return service.getStudentsBySchool(name);
	}

	// Get all students who passed or failed
	@GetMapping("/result")
	public List<Student> getStudentsByResult(@RequestParam boolean pass) {
		return service.getStudentsByResult(pass);
	}

	// Get count of students in a specific standard
	@GetMapping("/{standard}/count")
	public long getStudentCountByStandard(@PathVariable int standard) {
		return service.getStudentCountByStandard(standard);
	}

	// Get total strength of a school
	@GetMapping("/strength")
	public long getTotalStrengthBySchool(@RequestParam String school) {
		return service.getTotalStrengthBySchool(school);
	}

	// Get top 5 students by percentage
	@GetMapping("/toppers")
	public List<Student> getTopFiveStudents() {
		return service.getTopFiveStudents();
	}

	// Get topper of a specific standard
	@GetMapping("/topper/{standard}")
	public Optional<Student> getTopperByStandard(@PathVariable int standard) {
		return service.getTopperByStandard(standard);
	}
}
